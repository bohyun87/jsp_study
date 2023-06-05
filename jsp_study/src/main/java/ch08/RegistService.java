package ch08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//데이터 샘플을 제공해주는 클래스
public class RegistService {
    Map<String, Regist> register = new HashMap<>();
    
    public RegistService() {
   	 Regist r = new Regist("101", "김지은", "서울시", "silver", "010-1111-1111");
   	 register.put("101", r);
   	 
   	 r = new Regist("102", "홍길동", "인천시", "gold", "010-2222-2222");
   	 register.put("102", r);
   	 
   	 r = new Regist("103", "율곡", "김포시", "vip", "010-3333-3333");
   	 register.put("103", r);
    }
    
    //모든 고객 데이터를 가져오는 메소드(select * from)
    public ArrayList<Regist> findAll(){
   	 return new ArrayList<>(register.values());
    }
    
    //id로 원하는 고객을 가져오는 메소드(select * from where id="102")
    public Regist find(String id) {
   	 return register.get(id);
    }
    
    
}
