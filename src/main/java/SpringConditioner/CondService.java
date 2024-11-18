package SpringConditioner;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CondService {
    List <String>condList=new ArrayList<>();

    public void add (String cond){
        condList.add(cond);
    }

    public List<String> getCondList() {
        return condList;
    }

    @Override
    public String toString() {
        return "CondService{" +
                "condList=" + condList +
                '}';
    }
}
