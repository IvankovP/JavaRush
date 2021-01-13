package level_24.Bobr_MVC;

import level_24.Bobr_MVC.controller.Controller;
import level_24.Bobr_MVC.model.FakeModel;
import level_24.Bobr_MVC.model.MainModel;
import level_24.Bobr_MVC.model.Model;
import level_24.Bobr_MVC.view.EditUserView;
import level_24.Bobr_MVC.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        editUserView.fireEventUserDeleted(124);
        editUserView.fireEventUserChanged("New name!", 125, 99);
        usersView.fireEventShowDeletedUsers();
    }
}
