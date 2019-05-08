package loginapp;

import Admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import students.StudentsController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    LoginModel loginModel = new LoginModel();

    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginButton;
    @FXML
    private Label loginStatus;
    public void initialize(URL url, ResourceBundle rb) {
        if(this.loginModel.isDataConnected()){
            this.dbstatus.setText("połączono");
        }
        else {
            this.dbstatus.setText("nie połączono");
        }
        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    }

    @FXML
    public void Login(ActionEvent event){

        try{
            if(this.loginModel.isLogin(this.username.getText(),this.password.getText(),((option)this.combobox.getValue()).toString())) {
                Stage stage = (Stage) this.loginButton.getScene().getWindow();
                stage.close();
                switch (((option)this.combobox.getValue()).toString())
                {
                    case "Admin":
                        adminLogin();
                        break;
                    case "student":
                        studentLogin();
                        break;

                }
            }
                else{
                    this.loginStatus.setText("Złe dane");
                }




        }catch (Exception LocalException)    {
    }
        }

    public void studentLogin(){
    try{
        Stage UserStage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        Pane root = (Pane)loader.load(getClass().getResource("/students/studentsFXML.fxml").openStream());

        StudentsController studentsController = (StudentsController)loader.getController();

        Scene scene = new Scene(root);
        UserStage.setScene(scene);
        UserStage.setTitle("nowy tytuł");
        UserStage.setResizable(false);
        UserStage.show();



    }catch(IOException ex){
        ex.printStackTrace();
        }

    }
    public void adminLogin(){
        try{
            Stage AdminStage = new Stage();
            FXMLLoader adminLoader = new FXMLLoader();
            Pane adminroot = (Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());

            AdminController adminController = (AdminController)adminLoader.getController();

            Scene scene = new Scene(adminroot);
            AdminStage.setScene(scene);
            AdminStage.setTitle("nowy tytuł");
            AdminStage.setResizable(false);
            AdminStage.show();



        }catch(IOException ex){
            ex.printStackTrace();
        }

    }
}
