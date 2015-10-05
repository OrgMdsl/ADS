/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Web.Controller.Helpers.JsonHelper;
import Web.Model.ModalModel;
import Web.Utils.Enum.BotaoEnum;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author matheusdsl
 */
@Controller
public class ModalController {

    private ModalModel model;

    public ModalController() {
        model = new ModalModel();
    }

    @RequestMapping("ModalAtencao")
    public ResponseEntity<String> ModalAtencao(String corpo) {
        model.setTitulo("Atenção");
        model.setCorpo(corpo);
        BotaoEnum btns[] = {BotaoEnum.Cancelar, BotaoEnum.Ok};
        model.setBtns(btns);
        ResponseEntity<String> json = new JsonHelper<ModalModel>().ToJson(model);
        return json;
    }

}
