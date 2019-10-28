package sktvp18myshop;


import classes.App;

public class SKTVp18MyShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String flag = "base";
        if(args != null){
            flag = args[0];
        }
        App app = new App(flag);
        app.run();
    }
    
}