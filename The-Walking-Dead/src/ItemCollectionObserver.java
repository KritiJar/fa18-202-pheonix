import greenfoot.*;


public class ItemCollectionObserver implements Observer
{
    
    static int foodCount, swordParts, zombieCount,zombieKilled;
    String foodString, kitString, zombieString, swordString;
    public static boolean hasKit,hasGun ;
    public static boolean hasSword ;
    Creator creator;
    private static ItemCollectionObserver instance;
    
    
    private ItemCollectionObserver()
    {
        foodCount=0;
        swordParts=0;
        zombieCount=3;
        foodString="Food : 0";
        kitString = "Kit : Not Available";
        zombieString = "Zombies Killed: 0";
        swordString = "Sword : Not Available";
        hasKit=false;
        hasSword=false;
        zombieKilled=0;
        hasGun=false;
    }
    
    public static ItemCollectionObserver getInstance() {     
        if (null==instance)
            instance = new ItemCollectionObserver();
        return instance;
    }
    
    public void update(String item, Message m)
    {
        Human h1 = (Human) m.getWorld().getObjects(Human.class).get(0);
        if(item=="kit")
        {
            hasKit = !hasKit;
            if(hasKit)
            kitString = "Kit : Available";
            else
            kitString = "Kit : Not Available";
            if(hasKit==false)
            {
                creator = new KitFactory();
                m.getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500)); // Add kit to the world after it has been used.
            }
        }
        else if(item=="food"){
            foodCount++;
            foodString = "Food : "+foodCount;
            if(foodCount%3 == 0){
                creator = new FoodFactory();
                m.getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500)); // Add food at random places.
                m.getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
                m.getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
        }
        else if(item=="sword"){
            swordParts++;
            swordString = "Sword parts : "+swordParts+" out of 2";
            if(h1.swordState.hasFull()){ // Human has collected two parts of sword.
                swordString = "sword : Available";
                swordParts = 0;
                hasSword = true;
                GreenfootImage image1 = new GreenfootImage("Human with sword.png");
                image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
                h1.setImage(image1);
            }
        }
        else if(item=="zombie"){
            zombieKilled++;
            zombieString = "Zombies Killed: "+zombieKilled;
            
            swordParts = 0; // Reset sword as it is used to kill the zombie
            hasSword = false;
            swordString = "Sword : "+swordParts+" out of 2";
            GreenfootImage image1 = new GreenfootImage("Human.png");
            image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
            h1.setImage(image1);
            
            creator = new SwordFactory(); // Add new Sword parts for the human to collect and kill another zombie
            Actor s1 = creator.getActor();
            m.getWorld().addObject(s1, 80, 229);
            s1.setImage("handle.png");

            int x = Greenfoot.getRandomNumber(800);
            int y = Greenfoot.getRandomNumber(100);
            
            Actor s2 = creator.getActor();
            m.getWorld().addObject(s2, x+15, y+5);
            s2.setImage("blade.png");
            
        }
        else if (item=="zombieBullet")
        {
            zombieKilled++;
            zombieString = "Zombies Killed: "+zombieKilled;
        }
        else if(item=="gun")
        {
            hasGun = true;
       
        }
        
        m.setText(kitString +"\n"+ foodString +"\n"+ swordString + "\n" + zombieString);
    }
        
        
        
}
    
    
    
