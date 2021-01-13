package level_24.Bobr_MVC.view;

import level_24.Bobr_MVC.controller.Controller;
import level_24.Bobr_MVC.model.ModelData;

public interface View {
    void refresh(ModelData modelData);
    void setController(Controller controller);
}
