package level_24.Bobr_MVC.view;

import level_24.Bobr_MVC.bean.User;
import level_24.Bobr_MVC.controller.Controller;
import level_24.Bobr_MVC.model.ModelData;

public class UsersView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println(modelData.isDisplayDeletedUserList() ? "All deleted users:" : "All users:");
        for (User user : modelData.getUsers()) System.out.println("\t" + user);
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }

    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
