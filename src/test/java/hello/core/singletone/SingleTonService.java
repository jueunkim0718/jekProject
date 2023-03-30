package hello.core.singletone;

public class SingleTonService {

    private static final SingleTonService instance = new SingleTonService();

    public static SingleTonService getInstance(){
        return instance;
    }

    private SingleTonService(){

    }
    private void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
