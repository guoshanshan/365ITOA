package com.yfann.web.action;

import com.yfann.web.model.*;
import com.yfann.web.service.ProductService;
import com.yfann.web.utils.UUIDCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 产品控制器
 */
@Controller
@RequestMapping("/product")
public class ProductAction {
    @Autowired
    private ProductService productService;


    @RequestMapping("takeProductDatailImg")
    public void takeProductDatailImg(String id,HttpServletResponse response) throws Exception{
        response.getOutputStream().write(productService.takeProductDatailImg(id));
    }

    @RequestMapping("takeProductGreateImg")
    public void takeProductGreateImg(String id,HttpServletResponse response) throws Exception{
        response.getOutputStream().write(productService.takeProductGreateImg(id));
    }


    @RequestMapping("takeProductImg")
    public void takeProductImg(String id,HttpServletResponse response) throws Exception{
        response.getOutputStream().write(productService.takeProductImg(id));
    }

    /**
     * 根据产品主键获取缩略图
     *
     * @param product
     * @param response
     * @throws Exception
     */
    @RequestMapping("/takeProductHeadImg")
    public void takeProductHeadImg(Product product, HttpServletResponse response) throws Exception {
        response.getOutputStream().write(productService.takeProductHeadImg(product.getId()));
    }

    /**
     * 上传课程图片
     *
     * @param productId
     * @param request
     * @param imgType 1:课程logo  2:课程详情图 3:课程精彩截图
     * @param model
     * @return
     */
    @RequestMapping("/uploadProductImg")
    public String uploadProductImg(String productId,String imgType,HttpServletRequest request,Model model) throws Exception{
        MultipartHttpServletRequest multipartHttpServletRequest =  (MultipartHttpServletRequest)request;
        MultipartFile file = multipartHttpServletRequest.getFile("imgFile");
        int imgIntType = Integer.parseInt(imgType);
        switch (imgIntType){
            //课程logo
            case 1 : {
                ProductImage productImage = new ProductImage();
                productImage.setId(UUIDCreate.takeUUID());
                productImage.setProductId(productId);
                productImage.setProductImage(file.getBytes());
                productService.uploadProductImg(productImage);
                break;
            }
            //课程详情图
            case 2 : {
                ProductDetailImg producDetailImg = new ProductDetailImg();
                producDetailImg.setId(UUIDCreate.takeUUID());
                producDetailImg.setProductId(productId);
                producDetailImg.setProductDetailImg(file.getBytes());
                productService.uploadProductImg(producDetailImg);
                break;
            }
            //课程精彩截图
            case 3 : {
                ProductGreateImg productGreateImg = new ProductGreateImg();
                productGreateImg.setId(UUIDCreate.takeUUID());
                productGreateImg.setProductId(productId);
                productGreateImg.setGreatImg(file.getBytes());
                productService.uploadProductImg(productGreateImg);
                break;
            }
        }
        List<String> productDetailImgIdList =  productService.findProductDetailImgIdByProductId(productId);
        List<String> productGreateImgIdList = productService.findProductGreateImgIdByProductId(productId);
        List<String> productImgIdList = productService.findProductImgIdByProductId(productId);
        model.addAttribute("productDetailImgIdList", productDetailImgIdList);
        model.addAttribute("productGreateImgIdList", productGreateImgIdList);
        model.addAttribute("productImgIdList", productImgIdList);
        model.addAttribute("productId",productId);
        return "product/uploadProductImg";
    }

    /**
     *跳转到课程新增页面
     * @param model
     * @param id 课程主键
     * @return
     */
    @RequestMapping("/forwardUploadProductImg")
    public String forwardUploadProductImg(String id,Model model){
        List<String> productDetailImgIdList =  productService.findProductDetailImgIdByProductId(id);
        List<String> productGreateImgIdList = productService.findProductGreateImgIdByProductId(id);
        List<String> productImgIdList = productService.findProductImgIdByProductId(id);
        model.addAttribute("productId",id);
        model.addAttribute("productDetailImgIdList", productDetailImgIdList);
        model.addAttribute("productGreateImgIdList", productGreateImgIdList);
        model.addAttribute("productImgIdList", productImgIdList);
        return "product/uploadProductImg";
    }

    /**
     * 删除课程
     * @param id
     * @return
     */
    @RequestMapping("/deletePeoduct")
    public String deletePeoduct(String id){
        productService.deletePeoduct(id);
        return "redirect:/product/forwardProductList.action";
    }

    /**
     *跳转到课程新增页面
     * @param model
     * @return
     */
    @RequestMapping("/forwardCreateProduct")
    public String forwardCreateProduct(Model model){
        model.addAttribute("productStatusDicList",productService.findDicListByDicType("PRODUCT_STATUS"));
        return "product/createProduct";
    }


    /**
     * 保存课程
     * @param product
     * @return
     */
    @RequestMapping("/saveProduct")
    public String saveProduct(Product product){
        product.setId(UUIDCreate.takeUUID());
        productService.saveProduct(product);
        return "redirect:/product/forwardProductList.action";
    }

    /**
     * 跳转到课程列表
     * @return
     */
    @RequestMapping("/forwardProductList")
    public String forwardProductList(Model model){
        List<Product> productList =  productService.findAllProductList();
        model.addAttribute("productList",productList);
        return "product/productList";
    }

    /**
     * 跳转到课程编辑页面
     * @param product
     * @param model
     * @return
     */
    @RequestMapping("/forwardEditProduct")
    public String forwardEditProduct(Product product,Model model){
        model.addAttribute("productStatusDicList",productService.findDicListByDicType("PRODUCT_STATUS"));
        model.addAttribute("product",productService.findProduct(product));
        return "product/editProduct";
    }


    @RequestMapping("/editProduct")
    public String editProduct(Product product){
        productService.editProduct(product);
        return "redirect:/product/forwardProductList.action";
    }


    /**
     *
     * desc：绑定一个指定的时间类型的属性编辑器
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

}
