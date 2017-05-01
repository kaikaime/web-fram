package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.ProductCenterPriceMapper;
import com.shop.dao.ProductCenterRepositoryMapper;
import com.shop.dao.ProductImgMapper;
import com.shop.dao.ProductMapper;
import com.shop.dao.ProductPriceMapper;
import com.shop.dao.ProductRepositoryMapper;
import com.shop.dao.ShopCategoryChildMapper;
import com.shop.dao.ShopCategoryMapper;
import com.shop.pojo.ImgShopPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.PricePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.RepositoryPojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.ShopPojo;
import com.shop.pojo.ShopPricePojo;
import com.shop.pojo.ShopRepositoryPojo;
import com.shop.service.ProductManageService;

@Service
public class ProductManageServiceImpl implements ProductManageService{
	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	
	@Autowired
	private ShopCategoryChildMapper shopCategoryChildMapper;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductImgMapper productImgMapper;
	
	@Autowired
	private ProductPriceMapper productPriceMapper;
	
	@Autowired
	private ProductCenterPriceMapper productCenterPriceMapper;
	
	@Autowired
	private ProductRepositoryMapper productRepositoryMapper; 
	
	@Autowired
	private ProductCenterRepositoryMapper productCenterRepositoryMapper;
	
	
	//获取所有的类别
	@Override
	public List<ShopCategoryPojo> findAllProductCategoryService() {
		PagePojo<ShopCategoryPojo> pagePojo =
				new PagePojo<ShopCategoryPojo>();
		pagePojo.setIsLimit(0);
		List<ShopCategoryPojo> allShopCategory= 
				shopCategoryMapper.findAllUserList(pagePojo);
		return allShopCategory;
	}


	//通过大类名称查询
	@Override
	public List<ShopChildCategoryPojo> findAllProductChildCategoryService(
			String findProdcutNick) {
		List<ShopChildCategoryPojo> allShopChildCategory=
				shopCategoryChildMapper.findAllChildCategory(findProdcutNick);
		return allShopChildCategory;
	}


	//商品添加
	@Transactional
	@Override
	public void addProductManageService(ProductInfoPojo pif) {
		String productParent = pif.getProductParent();//添加大类
		//获取大类主键值
		Integer shopCategoryId = shopCategoryMapper.queryShopCategoryId(productParent);
		ShopCategoryPojo shopCategoryPojo = new ShopCategoryPojo();
		shopCategoryPojo.setShopCategoryId(shopCategoryId);
		
		//获取小类主键值
		String shopChildCategoryNick = pif.getProductChild();
		ShopChildCategoryPojo shopChildCategoryPojo = new ShopChildCategoryPojo();
		shopChildCategoryPojo.setShopCategoryPojo(shopCategoryPojo);
		shopChildCategoryPojo.setShopChildCategoryNick(shopChildCategoryNick);
		//通过小类的名称和大类的id获取小类的id
		Integer shopCategoryChildId = shopCategoryChildMapper.queryShopChildCategoryId(shopChildCategoryPojo);
		shopChildCategoryPojo.setShopChildCategoryId(shopCategoryChildId);

	
		//添加商品
		ShopPojo shopPojo = new ShopPojo();
		shopPojo.setShopName(pif.getProductName());
		shopPojo.setShopPinpai(pif.getProductPingpaiName());
		shopPojo.setShopTxm(pif.getTiaoxingma());
		shopPojo.setShopChildCategoryPojo(shopChildCategoryPojo);
		productMapper.addProduct(shopPojo);

		//添加商品图片
		ImgShopPojo imgShopPojo = new ImgShopPojo();
		imgShopPojo.setImgshopNick(pif.getImgUrl());
		imgShopPojo.setShop(shopPojo);
		productImgMapper.addProductImg(imgShopPojo);
		
		//添加商品价格,添加价格之前查看数据库中是否有当前的价格
		PricePojo pricePojo = new PricePojo();
		Integer productPriceId=productPriceMapper.queryProductPrice(pif.getProductPrice());
		System.out.println("productPriceId "+productPriceId);
		if(productPriceId==null){
			pricePojo.setPrice(pif.getProductPrice());
			productPriceMapper.addProductPrice(pricePojo);
		}else{
			pricePojo.setPriceId(productPriceId);
		}
		

		//插入商品价格中间表
		ShopPricePojo shopPricePojo = new ShopPricePojo();
		shopPricePojo.setPrice(pricePojo);
		shopPricePojo.setShop(shopPojo);
		productCenterPriceMapper.addProductCenterPrice(shopPricePojo);
		
		//添加库存
		RepositoryPojo repository = new RepositoryPojo();
		Integer repositoryId = productRepositoryMapper.queryRepository(pif.getProductRepo());
		if(repositoryId==null){
			repository.setShopNumber(pif.getProductRepo());
			productRepositoryMapper.addProductRepository(repository);
		}else{
			repository.setRepositoryId(repositoryId);
		}
		
		
		//插入商品库存中间表
		ShopRepositoryPojo shopRepositoryPojo= new ShopRepositoryPojo();
		shopRepositoryPojo.setShop(shopPojo);
		shopRepositoryPojo.setRepository(repository);
		productCenterRepositoryMapper.addProductCenterRepository(shopRepositoryPojo);
	}


	@Override
	public PagePojo<ShopPojo> findAll(int currentPage, int pageSize) {
		//获取数据总数
		PagePojo<ShopPojo> pagePojo = productMapper.findAllUserCount();	
		//设置页面的条目数和当前的页面
		pagePojo.setPageSizeAndCurrentPage(pageSize, currentPage);
		//开始进行分页计算
		pagePojo.jiSuanFenYe();
		//获取所有的数据
		List<ShopPojo> ShopPojo = productMapper.findAllUserList(pagePojo);
		//存放数据
		pagePojo.setList(ShopPojo);
		
		return pagePojo;
	}


	@Override
	public void deleteByIdProductService(int productId) {
		//删除商品的图片，
		productImgMapper.deleteByIdProductImg(productId);
		
		//删除商品和价格的中间表中的数据
		productCenterPriceMapper.deleteByIdProductCenterPrice(productId);
		
		//删除商品和仓库的中间表数据
		productCenterRepositoryMapper.deleteByIdProductCenterRepostory(productId);
		
		//删除商品
		productMapper.deleteByIdProduct(productId);
	}


	@Override
	public ProductInfoPojo findByIdProdcutService(int productId) {
		ProductInfoPojo productInfoPojo = new ProductInfoPojo();
		productInfoPojo.setProductId(productId);
		//查看类别
		ShopChildCategoryPojo scp = shopCategoryChildMapper.findByIdProduct(productId);
		productInfoPojo.setProductChildNick(scp.getShopChildCategoryNick());
		//先查询出商品
		ShopPojo shopPojo = productMapper.findByIdProduct(productId);
		productInfoPojo.setProductName(shopPojo.getShopName());
		productInfoPojo.setTiaoxingma(shopPojo.getShopTxm());
		productInfoPojo.setProductPingpaiName(shopPojo.getShopPinpai());
		productInfoPojo.setProductId(productId);
		
		//查询出商品的图片
		ImgShopPojo img = productImgMapper.findImgByProdcutId(productId);
		if(img!=null){
			productInfoPojo.setImgUrl(img.getImgshopNick());
		}
		//查询商品价格
		ShopPricePojo shopPricePojo = productCenterPriceMapper.findPriceByProductId(productId);
		if(shopPricePojo!=null){
			productInfoPojo.setProductPrice(shopPricePojo.getPrice().getPrice());
		}
		
		//获取商品的储存数量
		ShopRepositoryPojo shopRepositoryPojo=	productCenterRepositoryMapper.findRepositoryProductId(productId);
		if(shopRepositoryPojo!=null){
			productInfoPojo.setProductRepo(shopRepositoryPojo.getRepository().getShopNumber());
		}
		return productInfoPojo;
	}


	//更新商品的所有数据
	@Override
	public void updateByIdProductService(ProductInfoPojo productInfoPojo) {
		System.out.println("========="+productInfoPojo.toString());
		//更新商品
		if(productInfoPojo!=null){
			//先获取类别Id
			//获取大类别的Id，检查小类别的Id
			Integer chilCateId = shopCategoryChildMapper.findChildCategoryId(productInfoPojo.getProductChild());
			System.out.println("chilCateId:============ "+chilCateId);
			if(chilCateId!=null){
				//更新商品的内容
				ShopPojo shopPojo = new ShopPojo();
				shopPojo.setShopId(productInfoPojo.getProductId());
				shopPojo.setShopName(productInfoPojo.getProductName());
				shopPojo.setShopPinpai(productInfoPojo.getProductPingpaiName());
				shopPojo.setShopTxm(productInfoPojo.getTiaoxingma());
				ShopChildCategoryPojo scp=new ShopChildCategoryPojo();
				scp.setShopChildCategoryId(chilCateId);
				shopPojo.setShopChildCategoryPojo(scp);
				productMapper.updateShop(shopPojo);
				
				//更新商品的价格,首先检查数据表中有没有当前的价钱，如果有就不用更新，如果没有就直接添加一条数据
				Integer priceId = productPriceMapper.queryProductPrice(productInfoPojo.getProductPrice());
				System.out.println("priceId: "+priceId);
				PricePojo pi = new PricePojo();
				if(priceId==null){
					//往数据库中添加一条数据
					productPriceMapper.addProductPrice(pi);
					System.out.println("扫描商品价格添加后返回的几个Id"+pi.getPriceId());
					//再次往商品和价格中间表中添加数据
					ShopPricePojo spp = new ShopPricePojo();
					spp.setPrice(pi);
					spp.setShop(shopPojo);
					productCenterPriceMapper.addProductCenterPrice(spp);
				}else{
					pi.setPriceId(priceId);
					ShopPricePojo spp = new ShopPricePojo();
					spp.setPrice(pi);
					spp.setShop(shopPojo);
					productCenterPriceMapper.updateProductCenterPrice(spp);
				}
			}
		}
		
		
	}

}
