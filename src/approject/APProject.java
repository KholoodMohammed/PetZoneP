/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
  Team member:
   ثراء فريد سردار
      خلود محمد بديع 
رهف               
   رغد أبو هنودة  
أنفال الحارثي     
 */
package approject;


import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.scene.image.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.web.WebView;

import org.hibernate.*;


/**
 *
 * @author hp
 */
public class APProject extends Application {
    
    Scene AppointementScene;
    Scene ProfileScene;;
    Scene loginsignin;
    Scene sceneCP ;
    Scene scenePWR;
    Scene ToysScene;
    Scene FoodScene;
    Scene CareSuppliesScene;
    Scene ScenPayment;
    Scene Homepage;
    Scene Catagorybutton;
    Scene Cartbutton;
    
    private Media media;
    private MediaPlayer mediaPlayer;
    private MediaView mediaView;
   
    boolean userloged=false;
    String logedUser;
    

            
    @Override
    public void start(Stage primaryStage) {
        

         
    ObservableList<String> list= FXCollections.observableArrayList();   
    ObservableList<String> obAppointments= FXCollections.observableArrayList();
    Label Usernametxt =new Label("");    
    Label Hint=new Label(" ");
    Hint.setStyle("-fx-font-size: 0.85em; ");
/////////////Homepage//////////////////////////////////////////////////////////////////////////
BorderPane pane = new BorderPane();

ImageView imageView = new ImageView(new Image("approject/MicrosoftTeams-image.png"));//Setting the image view
// ImageView imageView = new ImageView(new Image("approject2/MicrosoftTeams-image.png"));//Setting the image view 
        
        
        imageView.setFitHeight(300); 
        imageView.setFitWidth(250);
        imageView.setPreserveRatio(true);
        
    
       
      /* String path="C:\\Users\\خلود\\Downloads\\Animation_ Animal Health Motion Graphic.mp4";
       Media media = new Media(new File(path).toURI().toString()); 
        
       mediaPlayer=new MediaPlayer(media);
       
       mediaPlayer.setAutoPlay(true);*/
      WebView webview =new WebView();
      webview.getEngine().load("https://www.youtube.com/embed/2Ngu6DIYhio");
       
      // mediaView=new MediaView(mediaPlayer);
      // mediaView.setFitHeight(600);
      // mediaView.setFitWidth(420);
       
        VBox vid = new VBox(15);
       Text lv=new Text("You can exit the application by press esc button in the keyboard");
        vid.getChildren().addAll(imageView,webview,lv);
        


//vid.getChildren().addAll(imageView,lv);

//إلاهنا
HBox Button = new HBox(15);
Button Account = new Button("Account");
Account.setMinSize(80,10);
Account.setStyle("-fx-background-color:#D6A4A5");
//Account.setTextFill(Color.WHITE);
//Account.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));
Account.setPadding(new Insets(10,10,10,10));

Button Category = new Button("Category");
Category.setMinSize(80,10);
Category.setPadding(new Insets(10,10,10,10));
Category.setStyle("-fx-background-color:#D6A4A5");
//Category.setTextFill(Color.WHITE);
//Category.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

Button Appointment = new Button("Appointment");
Appointment.setMinSize(80,10);
Appointment.setPadding(new Insets(10,10,10,10));
Appointment.setStyle("-fx-background-color:#D6A4A5");
//Appointment.setTextFill(Color.WHITE);
//Appointment.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

Button Cart = new Button("Cart");
Cart.setMinSize(80,10);
Cart.setPadding(new Insets(10,10,10,10));
Cart.setStyle("-fx-background-color:#D6A4A5");

//Cart.setTextFill(Color.WHITE);
//Cart.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

Button.setPadding(new Insets(20));
vid.setPadding(new Insets(20));
pane.setBottom(Button);
Button.setAlignment(Pos.CENTER);
vid.setAlignment(Pos.CENTER);
Button.getChildren().addAll(Account,Category,Appointment,Cart);
pane.setCenter(vid);
pane.setBottom(Button);
pane.setStyle("-fx-background-color:#ffffff");
        
        //////action///////
        Account.setOnAction(e -> {  
            if(userloged){
                Usernametxt.setText(logedUser);
                Usernametxt.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
                Usernametxt.setTextFill(Color.BLUE);
                obAppointments.clear();
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<Appointment> sList;
                String queryStr ="from Appointment";
                Query query = session.createQuery(queryStr);
                sList = query.list();
                session.close();

                if(sList.isEmpty()){}
                else{
                for(int i=0 ;i<sList.size();i++){
                if(sList.get(i).getUsername().equals(logedUser)){
                String appoint = sList.get(i).getUsername()+ " | " + sList.get(i).getDateAndTime()+ " | " + sList.get(i).getPetKind()+ " | " + sList.get(i).getService();
                
                obAppointments.add(appoint);
               }}}
                primaryStage.setScene(ProfileScene);
            }else{
                 primaryStage.setScene(loginsignin);   
            
            } 
                });
        Category.setOnAction(e -> {
            if(userloged){
               primaryStage.setScene(Catagorybutton);
            }else{
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("you need to log in");
            a.show();
            } 
            });
        
        Appointment.setOnAction(e -> {
            if(userloged){
                 primaryStage.setScene(AppointementScene);
                 
            }else{
            
                Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("you need to log in");
            a.show();
            } 
           });
        
        Cart.setOnAction(e -> { 
            if(userloged){
                list.clear();
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<ProductDB> anfallist;
                String queryStr ="from ProductDB";
                Query query = session.createQuery(queryStr);
                anfallist = query.list();
                session.close();

                
                for(int i=0 ;i<anfallist.size();i++){
                if(anfallist.get(i).getUsern() == null){    
}
                else{
                if(anfallist.get(i).getUsern().equals(logedUser)){
                String CartPa=anfallist.get(i).getProname()+" price :   "+anfallist.get(i).getProprice();
                
                list.add(CartPa);
               }}}
                if(list.isEmpty()){
                    Hint.setText("Message : you dont \nadd any thin to the cart");
                }else{
                    Hint.setText("");
                }
                primaryStage.setScene(Cartbutton);
            }else{
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("you need to log in");
            a.show();
            } 
            });
        
        //////action///////
        
        Homepage = new Scene(pane ,450 , 600);
/////////////Homepage////////////////////////////////////////////////////////////////////////// 
      
/////////////loginsignin//////////////////////////////////////////////////////////////////////////   
Label lblmsg1 = new Label();
         Label lblmsg2 = new Label();
     
         Label l1 = new Label("Account");
         l1.setAlignment(Pos.CENTER);
         l1.setFont(new Font( 24));
         Button back = new Button("back");
         back.setMinSize(50,10);
         back.setBackground(new Background(new BackgroundFill(Color.web("0xD6A4A5"), CornerRadii.EMPTY, Insets.EMPTY)));
 
        back.setOnAction(e->{
         primaryStage.setScene(Homepage);
    });
         Label l1login = new Label("Login");
         Button btl = new Button("login");
         btl.setBackground(new Background(new BackgroundFill(Color.web("0xD6A4A5"), CornerRadii.EMPTY, Insets.EMPTY)));
         btl.setMinSize(50,10);
         Label lognuame = new Label("Username:");
         TextField loginuname = new TextField();
         loginuname.setPromptText("Enter the user name..");
 
        
         Label logpass= new Label("Pass Word:");
         PasswordField logpassword = new PasswordField();
         logpassword.setPromptText("Enter password..");
         Label l1or = new Label("-------------------or-------------------");
         
          Label l1signin = new Label("Signin");
          Button bts = new Button("signin");
          bts.setBackground(new Background(new BackgroundFill(Color.web("0xD6A4A5"),  CornerRadii.EMPTY, Insets.EMPTY)));
          bts.setMinSize(50,10);
          Label fn = new Label("First Name:");
          TextField fname = new TextField();
          fname.setPromptText("Enter...");
        
          Label ln = new Label("Last Name:");
          TextField lname = new TextField();
          lname.setPromptText("Enter...");
        
          Label un = new Label("Username:");
          TextField uname = new TextField();
          uname.setPromptText("Enter...");
        
          Label em = new Label("Email:");
          TextField email = new TextField();
          email.setPromptText("**@email.com");
        
          Label pass= new Label("Pass Word:");
          PasswordField password = new PasswordField();
          password.setPromptText("must be 8 digits");
        
        
          Label passcon= new Label("Pass Word conformation:");
          PasswordField passwordcon = new PasswordField();
          passwordcon.setPromptText("Re enter password");
        
          Label gender= new Label("Gender:");
          HBox genderhbox = new HBox(20);

          RadioButton female = new RadioButton("Female");
          RadioButton male = new RadioButton("Male");

          female.setSelected(true);
          genderhbox.getChildren().addAll(female, male);

          ToggleGroup group = new ToggleGroup();
          female.setToggleGroup(group);
          male.setToggleGroup(group);


        
          Label dateofbirth= new Label("Date of birth:");
          DatePicker date = new DatePicker();
          date.setValue(LocalDate.now());
  
          VBox box1 = new VBox();
          box1.setPadding(new Insets(10, 10, 10, 10));
          box1.setSpacing(20);  
          box1.getChildren().addAll(lognuame,logpass);

          VBox box2 = new VBox();
          box2.setPadding(new Insets(10, 10, 10, 10));
          box2.setSpacing(8);
          box2.getChildren().addAll(loginuname,logpassword,lblmsg1,btl,l1or);
     
          VBox box3 = new VBox();
          box3.setPadding(new Insets(10, 10, 10, 10));
          box3.setSpacing(17);
          box3.getChildren().addAll( fn,ln,un,em,pass,passcon,gender,dateofbirth);

          VBox box4 = new VBox();
          box4.setPadding(new Insets(10, 10, 10, 10));
          box4.setSpacing(8);
          box4.getChildren().addAll(fname,lname,uname,email,password,passwordcon,genderhbox,date,lblmsg2,bts);
        
         GridPane gridPane = new GridPane();
         gridPane.setPadding(new Insets(5, 5, 5, 5));
         gridPane.setVgap(5);
         gridPane.setHgap(5);
         gridPane.setAlignment(Pos.TOP_LEFT);
         gridPane.add(l1, 3, 0);
         gridPane.add(back, 1, 0);
         gridPane.add(l1login, 3, 2);
         gridPane.add(box1,2,3);
         gridPane.add(box2,3,3);
         gridPane.add(l1signin,3,4);
         gridPane.add(box3,2,5);
         gridPane.add(box4,3,5);

         gridPane.setBackground(new Background(new BackgroundFill(Color.web("0xF3E9E9"), CornerRadii.EMPTY, Insets.EMPTY)));
    

      
       //actions signin
     bts.setOnAction(e-> {

             person p = new person();
                 if(fname.getText().isEmpty() || lname.getText().isEmpty() || uname.getText().isEmpty() || email.getText().isEmpty() || password.getText().isEmpty() || passwordcon.getText().isEmpty()){
                      lblmsg2.setText("please enter all the information");
                           return;
                 }
//name search
 
                 else{
                     Session session = HibernateUtil.getSessionFactory().openSession();
                     List<person> sList = null;
                    String queryStr = "from person";
                    Query query = session.createQuery(queryStr);
                   sList = query.list();

              System.out.println("person list size: "+sList.size());
            for(person s: sList){
            if(uname.getText().equals(s.getUname())){
                     System.out.println(s.getUname());
                      lblmsg2.setText("the username is taken please re enter");
                      return;
                     }

                     else if (password.getText()!=passwordcon.getText() && password.getText().length()!=8){
                      lblmsg2.setText("please re enter the password must be 8 digit");
                                   return;
                         }

            }     

                          LocalDate value = date.getValue();
                          String s="female" ;    
                          if (female.isSelected()){
                             s="female"; 
                          }
                          if (male.isSelected()){
                              s="male";
                          }
 
                              p.setFname(fname.getText());
                              p.setLname(lname.getText());
                              p.setUname(uname.getText());
                              p.setEmail(email.getText());
                              p.setPassword(password.getText());
                              p.setGender(s);
                              p.setDateofbirth(value.format(DateTimeFormatter.ISO_LOCAL_DATE));

                              Session sessionw = HibernateUtil.getSessionFactory().openSession();
                              Transaction tx = sessionw.beginTransaction();
                              String sId = (String)sessionw.save(p);
                              tx.commit();
                              sessionw.close();
                             System.out.println("inserted costumer: "+p.getFname() +" "+p.getLname() +" "+p.getUname() +" "+p.getEmail()+" "+p.getPassword()+" "+p.getGender().toString()+" "+p.getDateofbirth());
                              lblmsg2.setText("registration is successful");


                 }           
        });
               //actions login
        btl.setOnAction(e->{
             person p = new person();
           if (loginuname.getText().isEmpty() || logpassword.getText().isEmpty() || logpassword.getText().length()!=8){
                      lblmsg1.setText("please enter the information");
           return;}
           else{
               Session session = HibernateUtil.getSessionFactory().openSession();
                List<person> sList = null;
               String queryStr = "from person";
               Query query = session.createQuery(queryStr);
               sList = query.list();
               session.close();
               
              System.out.println("person list size: "+sList.size());
            for(person s: sList){
            if(loginuname.getText().equals(s.getUname()) && logpassword.getText().equals(s.getPassword())){
                     System.out.println(s.getUname()+" "+s.getPassword()+" "+s.getFname());
                     lblmsg1.setText("registration is successful");
                        userloged =true;
                        logedUser=s.getUname();
                Usernametxt.setText(logedUser);
                obAppointments.clear();
                Session session9 = HibernateUtil.getSessionFactory().openSession();
                List<Appointment> sList1;
                String queryStr9 ="from Appointment";
                Query query9 = session9.createQuery(queryStr9);
                sList1 = query9.list();
                session9.close();

                if(sList1.isEmpty()){}
                else{
                for(int i=0 ;i<sList1.size();i++){
                if(sList1.get(i).getUsername().equals(logedUser)){
                String appoint = sList1.get(i).getUsername()+ " | " + sList1.get(i).getDateAndTime()+ " | " + sList1.get(i).getPetKind()+ " | " + sList1.get(i).getService();
                
                obAppointments.add(appoint);
               }}}
                     primaryStage.setScene(ProfileScene);
                         
                     
            
            
            }
            
            else if(loginuname.getText()!=s.getUname() && logpassword.getText()!=s.getPassword()){
                    lblmsg1.setText("make sure user name and password are correct or signin");
                     
            }
            }
              }    
            
               });
          
     loginsignin = new Scene(gridPane ,450 , 600);
     
    //    loginsignin.setFill(Color.web("0xECEAE4"));

    
/////////////loginsignin////////////////////////////////////////////////////////////////////////// 

/////////////Catagorybutton//////////////////////////////////////////////////////////////////////////
BorderPane apane = new BorderPane();
HBox caback = new HBox();
Button Back = new Button("< Back");
apane.setPadding(new Insets(10));
caback.getChildren().addAll(Back);
Back.setStyle("-fx-background-color:#a3bbce");
VBox Button1 = new VBox(40);
Label Catagory=new Label("Catagory ");
Catagory.setStyle("-fx-font-size: 2.5em; ");
Catagory.setPadding(new Insets(20));
// Button.getChildren().add(Catagory );
apane.setCenter(Catagory);
// Button.setPadding(new Insets(10));

VBox caButton = new VBox(40);

Button Toys = new Button("Toys");
Toys.setStyle("-fx-font-size: 2em; -fx-background-color:#D6A4A5");
Toys.setMinSize(200,10);
Toys.setMaxSize(100,100);
Toys.setPrefSize(70,70);
Toys.setPadding(new Insets(14,15,14,15));
//Toys.setTextFill(Color.WHITE);
//Toys.setBackground(new Background(new setStyle("-fx-font-size: 2em; "), new CornerRadii(5), Style("-fx-background-color:#D6A4A5")));

Button Caresupplies = new Button("Care supplies");
Caresupplies.setStyle("-fx-font-size: 2em; -fx-background-color:#D6A4A5");
Caresupplies.setMinSize(200,10);
Caresupplies.setMaxSize(100,100);
Caresupplies.setPrefSize(70,70);
Caresupplies.setPadding(new Insets(14,15,14,15));
//Caresupplies.setTextFill(Color.WHITE);
//Caresupplies.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

Button Food = new Button("Food");
Food.setStyle("-fx-font-size: 2em; -fx-background-color:#D6A4A5");
Food.setMinSize(200,10);
Food.setMaxSize(100,100);
Food.setPrefSize(70,70);
Food.setPadding(new Insets(14,15,14,15));
//Food.setTextFill(Color.WHITE);
//Food.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

apane.setBottom(caButton);
caButton.setAlignment(Pos.TOP_CENTER);
caButton.getChildren().addAll(Toys,Caresupplies,Food);
caButton.setPadding(new Insets(50));
apane.setTop(Back);


apane.setCenter(Button1);
Button1.setAlignment(Pos.BOTTOM_CENTER);
Button1.getChildren().addAll(Catagory);
Button1.setPadding(new Insets(10));
apane.setStyle("-fx-background-color:#f3e9e9");


/////////action/////////
Back.setOnAction(e -> { primaryStage.setScene(Homepage);});
Toys.setOnAction(e -> { primaryStage.setScene(ToysScene);});
Caresupplies.setOnAction(e -> { primaryStage.setScene(CareSuppliesScene);});
Food.setOnAction(e -> { primaryStage.setScene(FoodScene);});
////////action/////////


Catagorybutton = new Scene(apane ,450 , 600);


/////////////Catagorybutton//////////////////////////////////////////////////////////////////////////

/////////////ToysScene//////////////////////////////////////////////////////////////////////////  
        HBox toysTop = new HBox(130);
        
        
        Button toysBackbtn = new Button("< Back");
        toysBackbtn.setStyle("-fx-background-color:#D6A4A5;");
        Label toyslbl = new Label("Toys");
        toyslbl.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
        toysTop.getChildren().addAll(toysBackbtn,toyslbl);


        //----------------------------------------------------------------------

        //cat
        ImageView toy1viewC = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTR8TGRLy6ObyEWDxC0Wf5WjZNpNJuMy49EOw&usqp=CAU"));
        toy1viewC.setFitHeight(200);
        toy1viewC.setFitWidth(200);

        Label toy1lblC = new Label("Cat Track Toy");
        Label toy1costC = new Label("29SR");
        Button toy1btnC = new Button("Add to cart");
        toy1btnC.setStyle("-fx-background-color:#D6A4A5;");


        VBox toy1C = new VBox(10);
        toy1C.getChildren().addAll(toy1viewC, toy1lblC, toy1costC, toy1btnC);
        toy1C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView toy2viewC = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXcwUfcSaZsuqstEmFrKrkGoUDSbCYNvpBJA&usqp=CAU"));
        toy2viewC.setFitHeight(200);
        toy2viewC.setFitWidth(200);

        Label toy2lblC = new Label("Cat Feather Toy");
        Label toy2costC = new Label("24SR");
        Button toy2btnC = new Button("Add to cart");
        toy2btnC.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox toy2C = new VBox(10);
        toy2C.getChildren().addAll(toy2viewC, toy2lblC, toy2costC, toy2btnC);
        toy2C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox toyspanecC = new HBox(10);
        toyspanecC.getChildren().addAll(toy1C, toy2C);
        //toyspanec.setAlignment(Pos.CENTER);

        //cat
        //dog
        ImageView toy1viewD = new ImageView(new Image("https://sc04.alicdn.com/kf/H65421e1e5b544859889491d6a8423c39O.jpg"));
        toy1viewD.setFitHeight(200);
        toy1viewD.setFitWidth(200);

        Label toy1lblD = new Label("Dog Chew Toys");
        Label toy1costD = new Label("12SR");
        Button toy1btnD = new Button("Add to cart");
        toy1btnD.setStyle("-fx-background-color:#D6A4A5;");


        VBox toy1D = new VBox(10);
        toy1D.getChildren().addAll(toy1viewD, toy1lblD, toy1costD, toy1btnD);
        toy1D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView toy2viewD = new ImageView(new Image("https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1590000973-s-bone-1590000956.jpg?crop=1xw:1xh;center,top&resize=768:*"));
        toy2viewD.setFitHeight(200);
        toy2viewD.setFitWidth(200);

        Label toy2lblD = new Label("S Dog Bone");
        Label toy2costD = new Label("30SR");
        Button toy2btnD = new Button("Add to cart");
        toy2btnD.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox toy2D = new VBox(10);
        toy2D.getChildren().addAll(toy2viewD, toy2lblD, toy2costD, toy2btnD);
        toy2D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox toyspanecD = new HBox(10);
        toyspanecD.getChildren().addAll(toy1D, toy2D);
        //toyspanec.setAlignment(Pos.CENTER);
        //dog
        //bird
        ImageView toy1viewB = new ImageView(new Image("https://img.chewy.com/is/image/catalog/155285_MAIN._AC_SL1500_V1542742682_.jpg"));
        toy1viewB.setFitHeight(200);
        toy1viewB.setFitWidth(200);

        Label toy1lblB = new Label("Coconut Bird Toys");
        Label toy1costB = new Label("20SR");
        Button toy1btnB = new Button("Add to cart");
        toy1btnB.setStyle("-fx-background-color:#D6A4A5;");


        VBox toy1B = new VBox(10);
        toy1B.getChildren().addAll(toy1viewB, toy1lblB, toy1costB, toy1btnB);
        toy1B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView toy2viewB = new ImageView(new Image("https://ae01.alicdn.com/kf/H0047e5aad1644888842a79502073ae97u/Bird-Swing-Toys-Parrot-Supplies-Hanging-Bridge-Swing-Standing-Bar-Stand-Frame-Biting-Toy-Bird-Cage.jpg"));
        toy2viewB.setFitHeight(200);
        toy2viewB.setFitWidth(200);

        Label toy2lblB = new Label("Bird Swing Toys");
        Label toy2costB = new Label("50SR");
        Button toy2btnB = new Button("Add to cart");
        toy2btnB.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox toy2B = new VBox(10);
        toy2B.getChildren().addAll(toy2viewB, toy2lblB, toy2costB, toy2btnB);
        toy2B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox toyspanecB = new HBox(10);
        toyspanecB.getChildren().addAll(toy1B, toy2B);        
        //bird
        ScrollPane scrolltoy =new ScrollPane();
        VBox toysRoot = new VBox(50);
        toysRoot.setPadding(new Insets(15,0,0,20));
        toysRoot.getChildren().addAll(toysTop,toyspanecC,toyspanecD,toyspanecB);
        scrolltoy.setContent(toysRoot);
        toysRoot.setStyle("-fx-background-color:#F3E9E9;");
        scrolltoy.setStyle("-fx-background-color:#F3E9E9;");
        ///////////action////////////
        toysBackbtn.setOnAction(e -> {  primaryStage.setScene(Catagorybutton);});

        toy1btnC.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Track Toy")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
   
        
        });
        
        toy2btnC.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Feather Toy")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        toy1btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Dog Chew Toys")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        toy2btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("S Dog Bone")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        toy1btnB.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Coconut Bird Toys")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        toy2btnB.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Bird Swing Toys")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        ///////////action////////////

        ToysScene = new Scene(scrolltoy,455,600);

/////////////ToysScene////////////////////////////////////////////////////////////////////////// 

/////////////FoodScene//////////////////////////////////////////////////////////////////////////  

        HBox foodTop = new HBox(130);
        Button foodBackbtn = new Button("< Back");
        foodBackbtn.setStyle("-fx-background-color:#D6A4A5;");
        Label foodlbl = new Label("Food");
        foodlbl.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
        foodTop.getChildren().addAll(foodBackbtn, foodlbl);
 
        
//cat
        //----------------------------------------------------------------------

        ImageView food1viewC = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_QOuU2yWZr_elJ-lXrgbYLSLwCXj3Ak5uLQ&usqp=CAU"));
        food1viewC.setFitHeight(200);
        food1viewC.setFitWidth(200);

        Label food1lblC = new Label("Cat Dry Food");
        Label food1costC = new Label("48SR");
        Button food1btnC = new Button("Add to cart");
        food1btnC.setStyle("-fx-background-color:#D6A4A5;");
        


        VBox food1C = new VBox(10);
        food1C.getChildren().addAll(food1viewC, food1lblC, food1costC, food1btnC);
        food1C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView food2viewC = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTln2sSMJ9nzgAzpXIVZRe2DeAS7QXwOYxiBg&usqp=CAU"));
        food2viewC.setFitHeight(200);
        food2viewC.setFitWidth(200);

        Label food2lblC = new Label("Cat Food Can");
        Label food2costC = new Label("32SR");
        Button food2btnC = new Button("Add to cart");
        food2btnC.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox food2C = new VBox(10);
        food2C.getChildren().addAll(food2viewC, food2lblC, food2costC, food2btnC);
        food2C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox foodpaneC = new HBox(10);
        foodpaneC.getChildren().addAll(food1C, food2C);
//cat
//dog

        ImageView food1viewD = new ImageView(new Image("https://m.media-amazon.com/images/I/61xFTcEHBEL._SL1000_.jpg"));
        food1viewD.setFitHeight(200);
        food1viewD.setFitWidth(200);

        Label food1lblD = new Label("Meat&Rice Dry Food");
        Label food1costD = new Label("60SR");
        Button food1btnD = new Button("Add to cart");
        food1btnD.setStyle("-fx-background-color:#D6A4A5;");


        VBox food1D = new VBox(10);
        food1D.getChildren().addAll(food1viewD, food1lblD, food1costD, food1btnD);
        food1D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView food2viewD = new ImageView(new Image("https://m.media-amazon.com/images/I/717HbmP4XlL._SL1000_.jpg"));
        food2viewD.setFitHeight(200);
        food2viewD.setFitWidth(200);

        Label food2lblD = new Label("Chicken&Vegetables Dog Food");
        Label food2costD = new Label("40SR");
        Button food2btnD = new Button("Add to cart");
        food2btnD.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox food2D = new VBox(10);
        food2D.getChildren().addAll(food2viewD, food2lblD, food2costD, food2btnD);
        food2D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox foodpaneD = new HBox(10);
        foodpaneD.getChildren().addAll(food1D, food2D);
//dog
//bird

        ImageView food1viewB = new ImageView(new Image("https://m.media-amazon.com/images/I/81srRybReeL._AC_SL1500_.jpg"));
        food1viewB.setFitHeight(200);
        food1viewB.setFitWidth(200);

        Label food1lblB = new Label("Food for Large Birds");
        Label food1costB = new Label("48SR");
        Button food1btnB = new Button("Add to cart");
        food1btnB.setStyle("-fx-background-color:#D6A4A5;");


        VBox food1B = new VBox(10);
        food1B.getChildren().addAll(food1viewB, food1lblB, food1costB, food1btnB);
        food1B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView food2viewB = new ImageView(new Image("https://assets.petco.com/petco/image/upload/f_auto,q_auto/2641776-center-1"));
        food2viewB.setFitHeight(200);
        food2viewB.setFitWidth(200);

        Label food2lblB = new Label("Food for Medium Birds");
        Label food2costB = new Label("34SR");
        Button food2btnB = new Button("Add to cart");
        food2btnB.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox food2B = new VBox(10);
        food2B.getChildren().addAll(food2viewB, food2lblB, food2costB, food2btnB);
        food2B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox foodpaneB = new HBox(10);
        foodpaneB.getChildren().addAll(food1B, food2B);
//bird
        ScrollPane scrollfood =new ScrollPane();
        VBox foodRoot = new VBox(50);
        foodRoot.setPadding(new Insets(15,0,0,20));
        foodRoot.getChildren().addAll(foodTop, foodpaneC,foodpaneD,foodpaneB);
        scrollfood.setContent(foodRoot);
        foodRoot.setStyle("-fx-background-color:#F3E9E9;");
        scrollfood.setStyle("-fx-background-color:#F3E9E9;");

        
        ///////////action////////////

        foodBackbtn.setOnAction(e -> {  primaryStage.setScene(Catagorybutton);});

        food1btnC.setOnAction(e -> {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Dry Food")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        food2btnC.setOnAction(e -> {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Food Can")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        food1btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Meat&Rice Dry Food")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        food2btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Chicken&Vegetables Dog Food")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        food1btnB.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Food for Large Birds")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        food2btnB.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Food for Medium Birds")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        ///////////action////////////
        
        FoodScene = new Scene(scrollfood,455,600);

       

/////////////FoodScene////////////////////////////////////////////////////////////////////////// 

/////////////CareSuppliesScene//////////////////////////////////////////////////////////////////////////  
        
        HBox careTop = new HBox(120);
        Button careBackbtn = new Button("< Back");
        careBackbtn.setStyle("-fx-background-color:#D6A4A5;");
        Label carelbl = new Label("Care Supplies");
        carelbl.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));

        careTop.getChildren().addAll(careBackbtn, carelbl);
 

//cat
        //----------------------------------------------------------------------

        ImageView care1viewC = new ImageView(new Image("https://ae01.alicdn.com/kf/H06e95a72d1bf4201b046d9b349b568762/Pet-Care-Glove-Cat-Grooming-Glove-Deshedding-Cat-Brush-Gloves-Dog-Comb-for-Cat-Supplies-Bath.jpg_Q90.jpg_.webp"));
        care1viewC.setFitHeight(200);
        care1viewC.setFitWidth(200);

        Label care1lblC = new Label("Cat Grooming Glove");
        Label care1costC = new Label("56SR");
        Button care1btnC = new Button("Add to cart");
        care1btnC.setStyle("-fx-background-color:#D6A4A5;");


        VBox care1C = new VBox(10);
        care1C.getChildren().addAll(care1viewC, care1lblC, care1costC, care1btnC);
        care1C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView care2viewC = new ImageView(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqgQbwOlc3TuIsM-SfrllanN9MnqUBD3Kz0g&usqp=CAU"));
        care2viewC.setFitHeight(200);
        care2viewC.setFitWidth(200);

        Label care2lblC = new Label("Cat Restraint Bag");
        Label care2costC = new Label("32SR");
        Button care2btnC = new Button("Add to cart");
        care2btnC.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox care2C = new VBox(10);
        care2C.getChildren().addAll(care2viewC, care2lblC, care2costC, care2btnC);
        care2C.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox carepaneC = new HBox(10);
        carepaneC.getChildren().addAll(care1C, care2C);


//cat
//dog
        //----------------------------------------------------------------------

        ImageView care1viewD = new ImageView(new Image("https://m.media-amazon.com/images/I/7198QBgdIfS._AC_SL1500_.jpg"));
        care1viewD.setFitHeight(200);
        care1viewD.setFitWidth(200);

        Label care1lblD = new Label("dog shampoo");
        Label care1costD = new Label("48SR");
        Button care1btnD = new Button("Add to cart");
        care1btnD.setStyle("-fx-background-color:#D6A4A5;");


        VBox care1D = new VBox(10);
        care1D.getChildren().addAll(care1viewD, care1lblD, care1costD, care1btnD);
        care1D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView care2viewD = new ImageView(new Image("https://labbvenn.com/518-large_default/loue-dog-bed.jpg"));
        care2viewD.setFitHeight(200);
        care2viewD.setFitWidth(200);

        Label care2lblD = new Label("dog bed");
        Label care2costD = new Label("90SR");
        Button care2btnD = new Button("Add to cart");
        care2btnD.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox care2D = new VBox(10);
        care2D.getChildren().addAll(care2viewD, care2lblD, care2costD, care2btnD);
        care2D.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox carepaneD = new HBox(10);
        carepaneD.getChildren().addAll(care1D, care2D);

//dog
//beird
        //----------------------------------------------------------------------

        ImageView care1viewB = new ImageView(new Image("https://www.hampshiregardensupplies.co.uk/images/products/large/1410.jpg"));
        care1viewB.setFitHeight(200);
        care1viewB.setFitWidth(200);

        Label care1lblB = new Label("Cosy Bird Box");
        Label care1costB = new Label("70SR");
        Button care1btnB = new Button("Add to cart");
        care1btnB.setStyle("-fx-background-color:#D6A4A5;");


        VBox care1B = new VBox(10);
        care1B.getChildren().addAll(care1viewB, care1lblB, care1costB, care1btnB);
        care1B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        //----------------------------------------------------------------------

        ImageView care2viewB = new ImageView(new Image("https://img.joomcdn.net/3fda8833e58cd11d34c9cdd433c02353a073cbcd_original.jpeg"));
        care2viewB.setFitHeight(200);
        care2viewB.setFitWidth(200);

        Label care2lblB = new Label("bird Feeding Device");
        Label care2costB = new Label("22SR");
        Button care2btnB = new Button("Add to cart");
        care2btnB.setStyle("-fx-background-color:#D6A4A5;");
 
        VBox care2B = new VBox(10);
        care2B.getChildren().addAll(care2viewB, care2lblB, care2costB, care2btnB);
        care2B.setStyle("-fx-border-color:black; -fx-border-width:2px;");

        HBox carepaneB = new HBox(10);
        carepaneB.getChildren().addAll(care1B, care2B);
        carepaneB.setAlignment(Pos.CENTER);
//beird
        ScrollPane scrollcare =new ScrollPane();
        VBox careRoot = new VBox(50);
        careRoot.setPadding(new Insets(15,0,0,20));
        careRoot.getChildren().addAll(careTop,carepaneC,carepaneD,carepaneB);
        scrollcare.setContent(careRoot);
        careRoot.setStyle("-fx-background-color:#F3E9E9;");
        scrollcare.setStyle("-fx-background-color:#F3E9E9;");

        ///////////action////////////

        careBackbtn.setOnAction(e -> {  primaryStage.setScene(Catagorybutton);});

        care1btnC.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Grooming Glove")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        care2btnC.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cat Restraint Bag")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        care1btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("dog shampoo")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        care2btnD.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList ;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("dog bed")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        care1btnB.setOnAction(e -> { 
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("Cosy Bird Box")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        
        care2btnB.setOnAction(e -> {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<ProductDB> pList;
        String queryStr ="from ProductDB";
        Query query = session.createQuery(queryStr);
        pList = query.list();
        session.close();
        
        boolean pselected=true;
            
        for(int i=0  ;i<pList.size();i++){
            
            if(pList.get(i).getProname().equals("bird Feeding Device")){
                if(pList.get(i).getUsern() == null){
                    int pid=pList.get(i).getProductid();
                    
                    session = HibernateUtil.getSessionFactory().openSession();
                    session.beginTransaction();
                    ProductDB p2;
                    p2 = (ProductDB)session.get(ProductDB.class, pid);
                    p2.setUsern(logedUser);
                    session.getTransaction().commit();
                    session.close();
                    pselected=false;
                    Alert tcompleted =new Alert(Alert.AlertType.INFORMATION);
                    tcompleted.setContentText("product added to the cart");
                    tcompleted.show();
                    
                    break;
                }
            }
        }    
        
        if(pselected){
            Alert a =new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("sorry product is out");
            a.show();
            //massege sorry priduct is out
        }
        });
        ///////////action////////////        
        
        CareSuppliesScene = new Scene(scrollcare, 455,600);

/////////////CareSuppliesScene////////////////////////////////////////////////////////////////////////// 

/////////////Cartbutton//////////////////////////////////////////////////////////////////////////
VBox v = new VBox();
HBox h1 = new HBox();
HBox h2 = new HBox();
HBox h3 = new HBox();
HBox h4 = new HBox();
HBox h5 = new HBox();
HBox h6 = new HBox();

Button BackA = new Button("< Back");
h1.getChildren().addAll(BackA);
h1.setPadding(new Insets(10));
BackA.setStyle("-fx-background-color:#a3bbce");
BackA.setOnAction(e->{
primaryStage.setScene(Homepage);
});
Label CatagoryA=new Label("Cart");
CatagoryA.setStyle("-fx-font-size: 2.5em; ");
h2.setAlignment(Pos.CENTER);
h2.getChildren().addAll(CatagoryA);

VBox Button2 = new VBox(700);
ListView lvlist = new ListView(list);
VBox VBlvlist = new VBox(700);
lvlist.setPrefSize(300, 200);
VBlvlist.getChildren().add( new ScrollPane(lvlist));
VBlvlist.setPadding(new Insets(80));
Button2.getChildren().addAll(VBlvlist);
h3.getChildren().addAll(Button2);


Button Gotocatagry = new Button("Go To Catagry");
Gotocatagry.setOnAction(e->{
primaryStage.setScene(Catagorybutton);
});
Gotocatagry.setStyle("-fx-font-size: 1.2em; -fx-background-color:#D6A4A5");
Gotocatagry.setMinSize(120,10);
Gotocatagry.setPadding(new Insets(4,10,4,10));
//Gotocatagry.setTextFill(Color.WHITE);
//Gotocatagry.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));

Button Buy = new Button("Buy ");
Buy.setOnAction(e->{
primaryStage.setScene(ScenPayment);
});
Buy.setStyle("-fx-font-size: 1.2em; -fx-background-color:#D6A4A5");
//Buy.setTextFill(Color.WHITE);
//Buy.setBackground(new Background(new BackgroundFill(Color.PINK, new CornerRadii(5), Insets.EMPTY)));
Buy.setMinSize(120,10);
Buy.setPadding(new Insets(4,10,4,10));


h6.setAlignment(Pos.CENTER);
h6.getChildren().addAll(Hint);
h6.setPadding(new Insets(4,10,4,10));
h6.setAlignment(Pos.BOTTOM_RIGHT);



h4.getChildren().addAll(Gotocatagry,Buy);h4.setSpacing(100);h4.setPadding(new Insets(20,50,50,50));
v.getChildren().addAll(h1,h2,h3,h4,h5,h6);
Cartbutton = new Scene(v ,450 , 600);
v.setStyle("-fx-background-color:#f3e9e9");
///Scene.setFill(Color.web("0xECEAE4"));
/////////////Cartbutton//////////////////////////////////////////////////////////////////////////

/////////////sceneCP//////////////////////////////////////////////////////////////////////////  


//BackButton card
Button btkbackc = new Button();
btkbackc.setText("Back");
btkbackc.setStyle("-fx-background-color:#d6a4a5");
Button btksubmitCard = new Button();
btksubmitCard.setText("Submit");
btksubmitCard.setAlignment(Pos.CENTER);
btksubmitCard.setStyle("-fx-background-color:#d6a4a5");

//Lableand textFied
TextField TCholder;
TextField TCnumber;
TextField TCcvv;
TextField TCEXPdata;
TextField TChomeaddress;
TextField TChomenumber;

Label Card_Pay_kp=new Label("Card Payment");
Card_Pay_kp.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 25));
Label lblmsg=new Label() ;

Label LaCholder=new Label("Card holder name :");

LaCholder.setAlignment(Pos.BOTTOM_RIGHT);

TCholder=new TextField();

TCholder.setPromptText("Enter");

Label LaCnumber=new Label("Card Number :");

LaCnumber.setAlignment(Pos.BOTTOM_RIGHT);

TCnumber=new TextField();
TCnumber.setPromptText("34*****");

Label LaCcvv=new Label("CVV :");

LaCcvv.setAlignment(Pos.BOTTOM_RIGHT);
TCcvv=new TextField();
TCcvv.setPromptText("XXXex.243");

Label LaCEXPdata=new Label("EXPIRES Endof date :");

LaCEXPdata.setAlignment(Pos.BOTTOM_RIGHT);
TCEXPdata=new TextField();
TCEXPdata.setPromptText("XXXXex.0721");

Label LaChomeaddress=new Label("Home Address :");

LaChomeaddress.setAlignment(Pos.BOTTOM_RIGHT);
TChomeaddress=new TextField();
TChomeaddress.setPromptText("Awali");


Label LaChomenumber=new Label("Home Number :");

LaChomenumber.setAlignment(Pos.BOTTOM_RIGHT);
TChomenumber=new TextField();
TChomenumber.setPromptText("2");



//sumbitOnActionCP
btksubmitCard.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent e) {
          int nEXP=0;
          String infr;
          if(TCholder.getText().isEmpty() | TCnumber.getText().isEmpty()|TCcvv.getText().isEmpty()|TCEXPdata.getText().isEmpty()|TChomeaddress.getText().isEmpty()|TChomenumber.getText().isEmpty()){
              
              lblmsg.setText("Enter the Information card ");
          }
          else
          {
              try{
                 long TCnum=Long.parseLong(TCnumber.getText());
                 int Ncvv=Integer.parseInt(TCcvv.getText());
                 nEXP=Ncvv=Integer.parseInt(TCEXPdata.getText());
                 lblmsg.setText("");
                 if(TCcvv.getText().length()!=3){
                     lblmsg.setText("Enter 3 integer in CVV");
                     
                 }
                 else{
                     lblmsg.setText(" ");
                      
          lblmsg.setText("Susscful !");
          
ObservableList<String> payoplist= FXCollections.observableArrayList();
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<ProductDB> klist;
                String queryStr ="from ProductDB";
                Query query = session.createQuery(queryStr);
                klist = query.list();
                session.close();

                
                for(int i=0 ;i<klist.size();i++){
                if(klist.get(i).getUsern() == null){    
}
                else{
                if(klist.get(i).getUsern().equals(logedUser)){
                   
                    payoplist.add(klist.get(i).getProname()+"     Price: "+klist.get(i).getProprice());
                    
                    Session sessio = HibernateUtil.getSessionFactory().openSession();
                    sessio = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = sessio.beginTransaction();
                    sessio.delete(klist.get(i));
                    tx.commit();
                    sessio.close();
                    
               }}}
                 String invoice=logedUser+".txt";
        java.io.File file = new java.io.File(invoice);
        if (file.exists()) {
        System.out.println("File already exists");
        }
    try {
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        for(int i=0;i<payoplist.size();i++){
            output.println(payoplist.get(i));
          
        }
        // Close the file
         output.close();
       
    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
        
    }
                     if(TCEXPdata.getText().length()!=4){
                         lblmsg.setText("Enter 4 integer in EXP");
                     }
                     
                 }
        
                  
              }
              catch(NumberFormatException m){
                  lblmsg.setText(" Enter only number not String ");
              }
              catch(Exception m){
                  System.out.println(m);
              }
              
              
              
              
         
          }
          
             }
  });
//Actions of Scene Card pay and pay when reiceved
btkbackc.setOnAction(e->{primaryStage.setScene(scenePWR);});
GridPane paneForCardPayment= new GridPane();
paneForCardPayment.setHgap(5);
paneForCardPayment.setVgap(10);
// paneForCardPayment.setBackground(Color.web("0xECEAE4"));
paneForCardPayment.setPadding(new Insets(10));
paneForCardPayment.add(btkbackc, 0, 0);
paneForCardPayment.add(Card_Pay_kp,3,1);
paneForCardPayment.add(LaCholder,2,3);
paneForCardPayment.add(TCholder,3,3);
paneForCardPayment.add(LaCnumber,2,4);
paneForCardPayment.add(TCnumber,3,4);
paneForCardPayment.add(LaCcvv,2,5);
paneForCardPayment.add(TCcvv,3,5);
paneForCardPayment.add(LaCEXPdata,2,6);
paneForCardPayment.add(TCEXPdata,3,6);
paneForCardPayment.add(LaChomeaddress,2,7);
paneForCardPayment.add(TChomeaddress,3,7);
paneForCardPayment.add(LaChomenumber,2,8);
paneForCardPayment.add(TChomenumber,3,8);
paneForCardPayment.add(btksubmitCard,3,10);
paneForCardPayment.add(lblmsg,3,12);
btkbackc.setOnAction(e->{primaryStage.setScene(ScenPayment);});
paneForCardPayment.setStyle("-fx-background-color:#f3e9e9");
//Actions of Scene Card
sceneCP = new Scene(paneForCardPayment,450, 600);

/////////////sceneCP//////////////////////////////////////////////////////////////////////////

/////////////scenePWR//////////////////////////////////////////////////////////////////////////
////BackButton Pay when Recieved
Button btkbackR = new Button();
btkbackR.setText("Back");
btkbackR.setStyle("-fx-background-color:#d6a4a5");
Button btksubmitRec = new Button();
btksubmitRec.setText("Submit");
btksubmitRec.setAlignment(Pos.CENTER);
btksubmitRec.setStyle("-fx-background-color:#d6a4a5");

//Lableand textFied
TextField ThomeaddressPWR;
TextField ThomenumberPWR;
Label lblmsg2k=new Label() ;
Label Pay_w_Rec=new Label(" Payment when receiving ");
Pay_w_Rec.setFont(Font.font("Algerian", FontWeight.BOLD, FontPosture.REGULAR, 15));
Label LaRihomeaddress=new Label("Home Address :");
//LaRihomeaddress.setMinWidth(100);
LaRihomeaddress.setAlignment(Pos.BOTTOM_RIGHT);
ThomeaddressPWR=new TextField();
ThomeaddressPWR.setPromptText("Awali");


Label LaRihomenumber=new Label("Home Number :");

LaRihomenumber.setAlignment(Pos.BOTTOM_RIGHT);
ThomenumberPWR=new TextField();
ThomenumberPWR.setPromptText("1");
//sumbitOnActionPWR
btksubmitRec.setOnAction(e->{
if(ThomeaddressPWR.getText().isEmpty() &ThomenumberPWR.getText().isEmpty()){
lblmsg2k.setText("Enter the Information card");

}

else if (ThomeaddressPWR.getText().isEmpty()){
    lblmsg2k.setText("Enter home address");
}
else if (ThomenumberPWR.getText().isEmpty()){
    lblmsg2k.setText("Enter home number");
}
else{
   
lblmsg2k.setText("Susscful !!!!"); 

                ObservableList<String> payoplist= FXCollections.observableArrayList();
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<ProductDB> klist;
                String queryStr ="from ProductDB";
                Query query = session.createQuery(queryStr);
                klist = query.list();
                session.close();

                
                for(int i=0 ;i<klist.size();i++){
                if(klist.get(i).getUsern() == null){    
}
                else{
                if(klist.get(i).getUsern().equals(logedUser)){
                   
                    payoplist.add(klist.get(i).getProname()+"     Price: "+klist.get(i).getProprice());
                    
                    Session sessio = HibernateUtil.getSessionFactory().openSession();
                    sessio = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = sessio.beginTransaction();
                    sessio.delete(klist.get(i));
                    tx.commit();
                    sessio.close();
                    
               }}}
                 String invoice=logedUser+".txt";
        java.io.File file = new java.io.File(invoice);
        if (file.exists()) {
        System.out.println("File already exists");
        }
    try {
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        for(int i=0;i<payoplist.size();i++){
            output.println(payoplist.get(i));
          
        }
        // Close the file
         output.close();
       
    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
        
    }
     

}
});
//Actions of Scene and pay when reiceved




btkbackR.setOnAction(e->{primaryStage.setScene(ScenPayment);});



//PWRS2
GridPane paneForPaywhenRecieved=new GridPane();
paneForPaywhenRecieved.setHgap(5);
paneForPaywhenRecieved.setVgap(10);
paneForPaywhenRecieved.setPadding(new Insets(10));
paneForPaywhenRecieved.add(btkbackR, 0, 0);
paneForPaywhenRecieved.add(Pay_w_Rec,3,1);
paneForPaywhenRecieved.add(LaRihomeaddress,2,5);
paneForPaywhenRecieved.add(ThomeaddressPWR,3,5);
paneForPaywhenRecieved.add(LaRihomenumber,2,6);
paneForPaywhenRecieved.add(ThomenumberPWR,3,6);
paneForPaywhenRecieved.add(btksubmitRec,3,7);
paneForPaywhenRecieved.add(lblmsg2k,3,9);

paneForPaywhenRecieved.setStyle("-fx-background-color:#f3e9e9");
scenePWR = new Scene(paneForPaywhenRecieved,450, 600);

/////////////scenePWR//////////////////////////////////////////////////////////////////////////


/////////////ScenPayment//////////////////////////////////////////////////////////////////////////
VBox paneForRadioB=new VBox(20);

Label laPay=new Label("Payment");
laPay.setFont(Font.font("Algerian", FontWeight.LIGHT, FontPosture.REGULAR, 40));
Label mags3k = new Label();
RadioButton card=new RadioButton("Card");
RadioButton payinstore=new RadioButton("Pay in the store");
RadioButton pay_recieving=new RadioButton("Pay when recieving");
paneForRadioB.setPadding(new Insets(5,5,5,5));

ToggleGroup GrR=new ToggleGroup();
card.setToggleGroup(GrR);
payinstore.setToggleGroup(GrR);
pay_recieving.setToggleGroup(GrR);

//BackButton
Button btkback = new Button();
btkback.setText("Back");
btkback.setStyle("-fx-background-color:#d6a4a5");
Button btksubmit = new Button();
btksubmit.setText("Submit");
btksubmit.setStyle("-fx-background-color:#d6a4a5");

paneForRadioB.getChildren().addAll(laPay,card,payinstore,pay_recieving, btksubmit);
//sumbitOnAction
btksubmit.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
if(card.isSelected()){
primaryStage.setScene(sceneCP);
mags3k.setText(card.getText());


}
else if(payinstore.isSelected()){
   mags3k.setText(payinstore.getText()); 
   
 ObservableList<String> payoplist= FXCollections.observableArrayList();
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                List<ProductDB> klist;
                String queryStr ="from ProductDB";
                Query query = session.createQuery(queryStr);
                klist = query.list();
                session.close();

                
                for(int i=0 ;i<klist.size();i++){
                if(klist.get(i).getUsern() == null){    
}
                else{
                if(klist.get(i).getUsern().equals(logedUser)){
                   
                    payoplist.add(klist.get(i).getProname()+"     Price: "+klist.get(i).getProprice());
                    
                    Session sessio = HibernateUtil.getSessionFactory().openSession();
                    sessio = HibernateUtil.getSessionFactory().openSession();
                    Transaction tx = sessio.beginTransaction();
                    sessio.delete(klist.get(i));
                    tx.commit();
                    sessio.close();
                    
               }}}
                 String invoice=logedUser+".txt";
        java.io.File file = new java.io.File(invoice);
        if (file.exists()) {
        System.out.println("File already exists");
        }
    try {
        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);
        for(int i=0;i<payoplist.size();i++){
            output.println(payoplist.get(i));
          
        }
        // Close the file
         output.close();
       
    } catch (FileNotFoundException ex) {
        System.out.println(ex.getMessage());
        
    }

}
else if(pay_recieving.isSelected()){
   mags3k.setText(pay_recieving.getText()); 
 primaryStage.setScene(scenePWR);
 

}
else
    mags3k.setText("Please choose a payment method");

}
});
////BackOnAction

btkback.setOnAction(e->{primaryStage.setScene(Cartbutton);});

GridPane Payment=new GridPane();
Payment.setHgap(10);
Payment.setVgap(10);
Payment.setPadding(new Insets(10));


Payment.add(btkback,0,0);
Payment.add(laPay,9,3);
Payment.add(card,9,6);
Payment.add(payinstore,9,7);
Payment.add(pay_recieving,9,8);
Payment.add(btksubmit,9,13);
Payment.add(mags3k,9,11);

Payment.setStyle("-fx-background-color:#f3e9e9");
ScenPayment = new Scene(Payment, 450, 600);

/////////////ScenPayment//////////////////////////////////////////////////////////////////////////




/////////////AppointementScene//////////////////////////////////////////////////////////////////////////
        BorderPane AppointmentPane = new BorderPane();
        
        
        
        //--TOP PART--//
        Button AppointmentBackbtn = new Button("back");
        AppointmentBackbtn.setStyle("-fx-background-color:#d6a4a5");
        
        Text appointmentTitle = new Text("Appointment");
        appointmentTitle.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
        
        HBox AppointmentTop = new HBox(100);
        AppointmentTop.setPadding(new Insets(15,0,0,20));
        AppointmentTop.getChildren().addAll(AppointmentBackbtn,appointmentTitle);
        AppointmentTop.setStyle("-fx-background-color:#f3e9e9");
        
        AppointmentPane.setTop(AppointmentTop);
        
        //--TOP PART--//
        
        //----------------------------------------------------------------------
        
        //--CENTER PART--//
        VBox contentPane = new VBox(60);
        contentPane.setAlignment(Pos.TOP_CENTER);
        contentPane.setPadding(new Insets(90,0,0,0));
        contentPane.setStyle("-fx-background-color:#f3e9e9");
    
        //----------------------------------------------------------------------
        
        //choose the date section
        DatePicker DatePickerPart = new DatePicker();
        DatePickerPart.setValue(LocalDate.now());
        
        Label chooseDatelbl = new Label("             choose the date :   ");
        
        HBox datepane = new HBox();
        datepane.getChildren().addAll(chooseDatelbl, DatePickerPart);
        contentPane.getChildren().add(datepane);
        //choose the date section
        
        //----------------------------------------------------------------------
        
        //choose the time section
        ComboBox<String> chooseTimeCombo = new ComboBox();
        chooseTimeCombo.getItems().addAll("8:00 AM", "9:00 AM","10:00 AM","11:00 AM","12:00 PM", "1:00 PM","2:00 PM", "3:00 PM", "4:00 PM" );
        chooseTimeCombo.setValue("8:00 AM");
        chooseTimeCombo.setStyle("-fx-background-color:#a3bbce");
 
        Label chooseTimelbl = new Label("             choose the time :   ");
        
        HBox timepane = new HBox();
        timepane.getChildren().addAll(chooseTimelbl, chooseTimeCombo);
        contentPane.getChildren().add(timepane);
        
        //choose the time section

        //----------------------------------------------------------------------
        
        //choose the pet section
        ComboBox<String> choosePetCombo = new ComboBox();
        choosePetCombo.getItems().addAll("cat", "dog","bird" );
        choosePetCombo.setValue("cat");
        choosePetCombo.setStyle("-fx-background-color:#a3bbce");
       
        Label choosePetlbl = new Label("             choose pet :           ");
        
        HBox petpane = new HBox();
        petpane.getChildren().addAll(choosePetlbl, choosePetCombo);
        contentPane.getChildren().add(petpane);
        //choose the pet section
      
        //----------------------------------------------------------------------
       
        //choose service section
        ComboBox<String> ServiceCombo = new ComboBox();
        ServiceCombo.getItems().addAll("examination", "nail clip", "teeth brush", "shower");
        ServiceCombo.setValue("examination");
        ServiceCombo.setStyle("-fx-background-color:#a3bbce");
        
        Label servicelbl = new Label("             service :                  ");
        
        HBox servicepane = new HBox();
        servicepane.getChildren().addAll(servicelbl, ServiceCombo);
        contentPane.getChildren().add(servicepane);
        //choose service section
        
        //----------------------------------------------------------------------
        
        AppointmentPane.setCenter(contentPane);
        
        //--CENTER PART--//

        //----------------------------------------------------------------------
        
        //--BOTTOM PART--//
        VBox AppointmentBottomPane = new VBox(15);
        AppointmentBottomPane.setPadding(new Insets(0,0,60,0));
        AppointmentBottomPane.setStyle("-fx-background-color:#f3e9e9");
        
        Button AppointmentSubmitbtn = new Button("submit");
        AppointmentSubmitbtn.setStyle("-fx-background-color:#d6a4a5");
        
        Label bookedmessage= new Label();
        
        bookedmessage.setTextFill(Color.RED);
        AppointmentBottomPane.setAlignment(Pos.TOP_CENTER);
        AppointmentBottomPane.getChildren().add(AppointmentSubmitbtn);
        
        //submit button action
        AppointmentSubmitbtn.setOnAction(e -> {//Save to database part
                            Session Session = HibernateUtil.getSessionFactory().openSession();
                            List<Appointment> sList;
                           
                            String queryStr3 = "from Appointment";
                            Query query2 = Session.createQuery(queryStr3);
                            sList = query2.list();
                            Session.close();
                            String datetime = DatePickerPart.getValue() + " " + chooseTimeCombo.getValue();
                            boolean istaken = true;
                            if(sList.isEmpty()){
            
                                   Appointment a = new Appointment();
        
                                    a.setDateAndTime(datetime);
                                    a.setService(ServiceCombo.getValue());
                                    a.setPetKind(choosePetCombo.getValue());
                                    a.setUsername(logedUser);
        
                                    Session session6 = HibernateUtil.getSessionFactory().openSession();
                                    session6 = HibernateUtil.getSessionFactory().openSession();
                                    Transaction tx = session6.beginTransaction();
                                    session6.save(a);
                                    tx.commit();
                                    session6.close();
                                    System.out.println("inserted User: "+a.getUsername());
                            
                                    bookedmessage.setText("Appointment booked!");
                               }
                            else{
                            
                            for(Appointment s: sList){
                               System.out.println(s.getDateAndTime());
                               if(s.getDateAndTime().equals(datetime)){
                                   bookedmessage.setText("The time and Date are reserved");
                                   istaken = false;
                                   break;
                               }
                            }
                            if(istaken){
                                   Appointment a = new Appointment();
        
                                    a.setDateAndTime(datetime);
                                    a.setService(ServiceCombo.getValue());
                                    a.setPetKind(choosePetCombo.getValue());
                                    a.setUsername(logedUser);
        
                                    Session session7 = HibernateUtil.getSessionFactory().openSession();
                                    session7 = HibernateUtil.getSessionFactory().openSession();
                                    Transaction tx = session7.beginTransaction();
                                    session7.save(a);
                                    tx.commit();
                                    session7.close();
                                    System.out.println("inserted User: "+a.getUsername());
                            
                                    bookedmessage.setText("Appointment booked!");
                               }
                            }
                            
                            
                            AppointmentBottomPane.getChildren().add(bookedmessage);});
                            AppointmentBackbtn.setOnAction(e -> {  primaryStage.setScene(Homepage);});
        //submit button action
        
        AppointmentPane.setBottom(AppointmentBottomPane);
        
        //--BOTTOM--//
        
        AppointementScene = new Scene(AppointmentPane, 450, 600);
        Color Appointmentbackground = Color.rgb(237,234,229);
        AppointementScene.setFill(Appointmentbackground);
        
        
////////////////AppointementScene/////////////////////////////////////////////////////////////////////////  


/////////////ProfileScene//////////////////////////////////////////////////////////////////////////
        BorderPane ProfileRootPane = new BorderPane();
        ProfileRootPane.setStyle("-fx-background-color:#f3e9e9");
        
        
        //TOP
        Button ProfileBackbtn = new Button("back");
        ProfileBackbtn.setStyle("-fx-background-color:#d6a4a5");
        
        Text ProfileTitle = new Text("Profile");
        ProfileTitle.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
        
        HBox ProfileTop = new HBox(120);
        ProfileTop.setPadding(new Insets(15,0,0,25));
        ProfileTop.getChildren().addAll(ProfileBackbtn,ProfileTitle);
        ProfileTop.setStyle("-fx-background-color:#f3e9e9");
        
        ProfileRootPane.setTop(ProfileTop);
        
        //CENTER
        VBox ProfileContent = new VBox(30);
        ProfileContent.setAlignment(Pos.TOP_CENTER);
        ProfileContent.setPadding(new Insets(90,0,0,0));
        ProfileContent.setStyle("-fx-background-color:#f3e9e9");
        
        
        HBox WelcomeUser = new HBox();
        WelcomeUser.setAlignment(Pos.CENTER);
        
        Text WelcomeTxt = new Text("Welcome  ");
        WelcomeTxt.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 22));
        
        
       
       

        
        WelcomeUser.getChildren().addAll(WelcomeTxt,Usernametxt);
        ProfileContent.getChildren().add(WelcomeUser);
        
        Text appointmentText = new Text("your current Appointment is :  ");
        appointmentText.setFont(Font.font("Goudy Old Style", FontWeight.BOLD, FontPosture.REGULAR, 20));
        ProfileContent.getChildren().add(appointmentText);
        
        
        ListView Appointmentslv = new ListView(obAppointments);
        Appointmentslv.setPrefHeight(200);
        
        
        ProfileContent.getChildren().add(Appointmentslv);
        
        Label goToAppointmentlbl = new Label("Click secondary button on list to go to appontment");
        goToAppointmentlbl.setStyle("-fx-background-color:#d3e5ee");
        goToAppointmentlbl.setAlignment(Pos.CENTER);
        
        ProfileContent.getChildren().add(goToAppointmentlbl);
        
        
        ProfileRootPane.setCenter(ProfileContent);
        
        
        //back button action
        ProfileBackbtn.setOnAction(e -> {  primaryStage.setScene(Homepage);});
        
        Appointmentslv.setOnMouseClicked(e -> {
                            if(e.getButton()==MouseButton.SECONDARY){
                                primaryStage.setScene(AppointementScene);
                            }});
        
        
        
        ProfileScene = new Scene(ProfileRootPane, 450, 600);


/////////////ProfileScene//////////////////////////////////////////////////////////////////////////

 AppointementScene.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         ProfileScene.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         loginsignin.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         sceneCP.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         scenePWR.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         ToysScene.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         FoodScene.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         CareSuppliesScene.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         ScenPayment.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         Homepage.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         Catagorybutton.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});
         Cartbutton.setOnKeyPressed(e -> {if (e.getCode() == KeyCode.ESCAPE) {System.exit(0);}});

         
/////////////////stage///////////////////////////////////////////////////////////////////////////        
        primaryStage.setTitle("Pet zone");
        primaryStage.setScene(Homepage);
        primaryStage.show();
    }



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
