package SpringConditioner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CondController {

    @Autowired
    CondService condService;

    @GetMapping("get_result")
    public String getResult(String mode, String wanted, String current, Model model){
        try {
            int t1=Integer.parseInt(current);
            int t2=Integer.parseInt(wanted);
            String res= String.valueOf(Conditioner.getResultTemp(t1, t2, mode));
            model.addAttribute("res", res);
            String history = "mode = "+ mode+" ; t wanted = "+ wanted +"; t current = "+ current;
            condService.add(history);
            model.addAttribute("history", condService.getCondList());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            model.addAttribute("errorMsg", e.getMessage());
        }
        return "index";
    }
}
