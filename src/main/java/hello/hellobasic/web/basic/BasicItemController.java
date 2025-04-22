package hello.hellobasic.web.basic;

import hello.hellobasic.domain.item.Item;
import hello.hellobasic.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {
    public final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable("itemId") long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";

    }


    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }


    //    @PostMapping("/add")
    public String addItmeV1(
            @RequestParam("itemName") String itemName
            , @RequestParam("price") int price
            , @RequestParam("quantity") int quantity
            , Model model
    ) {

        Item item = new Item(itemName, price, quantity);
        itemRepository.save(item);
        model.addAttribute("item", item);

        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItmeV2(
            @ModelAttribute("item") Item item
            , Model model
    ) {
        itemRepository.save(item);
        //model.addAttribute("item",item); // 자동추가 ,생략가능
        return "basic/item";
    }

    //    @PostMapping("/add")
    public String addItmeV3(
            @ModelAttribute Item item
            , Model model
    ) {
        itemRepository.save(item);
        //model.addAttribute("item",item); // 자동추가 ,생략가능
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItmeV4(
            Item item
            , Model model
    ) {
        itemRepository.save(item);
        //model.addAttribute("item",item); // 자동추가 ,생략가능
        // 해당 페이지로 이동한후 url 이 변경되지 않아 브라우저 새로고침시 post 요청발생하는 문제
        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItmeV5(
            Item item
            , Model model
    ) {
        itemRepository.save(item);
        //model.addAttribute("item",item); // 자동추가 ,생략가능
        return "redirect:/basic/items/" + item.getId();
    }

    @PostMapping("/add")
    public String addItmeV6(
            Item item
            , Model model
            , RedirectAttributes redirectAttributes
            ) {
        Item savedItem = itemRepository.save(item);
        //model.addAttribute("item",item); // 자동추가 ,생략가능
        redirectAttributes.addAttribute("itemId",savedItem.getId());
        redirectAttributes.addAttribute("status",true);
        // html 에서 param.status로 편리하게 조회 가능.
        return "redirect:/basic/items/{itemId}";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable("itemId") long itemId, Model model){
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item",item);
        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable("itemId") long itemId, @ModelAttribute Item item){
       itemRepository.update(itemId,item);
        return "redirect:/basic/items/{itemId}";
    }

    @PostConstruct
    public void init() {
        // 테스트 데이터 추가
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
