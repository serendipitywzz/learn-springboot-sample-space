package ink.openmind.springbootsamplebaselearnproject.controller;

import ink.openmind.springbootsamplebaselearnproject.entity.SaleGoods;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Wangzhuang2
 * @version : 1.0.0
 * @date ：Created in 2020/11/14 11:37
 * DESC
 */
@Controller
public class TestController {

    //@RequestMapping(value = "/post/httpmessageconverter", method = RequestMethod.POST)
//    @PostMapping(value = "/post/httpmessageconverter")
//    @ResponseBody
//    public SaleGoods httpMessageConverterTestPost(SaleGoods saleGoods){
//        System.out.println("=》 " + saleGoods.toString());
//        saleGoods.setType(saleGoods.getType() + 1);
//        saleGoods.setGoodsName("商品名称： " + saleGoods.getGoodsName());
//        return saleGoods;
//    }

    @RequestMapping(value = "/post/httpmessageconverter", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public SaleGoods httpMessageConverter(@RequestBody SaleGoods saleGoods){
        System.out.println(saleGoods);
        saleGoods.setType(saleGoods.getType() + 1);
        saleGoods.setGoodsName("商品名称： " + saleGoods.getGoodsName());
        return saleGoods;
    }

        @RequestMapping(value = "/get/httpmessageconverter", method = RequestMethod.GET)
    @ResponseBody
    public SaleGoods httpMessageConverterTestGet(){
        SaleGoods saleGoods = new SaleGoods();
        saleGoods.setGoodsName("iPhone - 12");
        saleGoods.setId(1);
        saleGoods.setOnSale(true);
        saleGoods.setType(1);
        saleGoods.setWeight(300);
        return saleGoods;
    }
}
