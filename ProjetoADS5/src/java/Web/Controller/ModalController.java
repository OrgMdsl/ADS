/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web.Controller;

import Web.Controller.Helpers.JsonHelper;
import Web.Utils.Class.ModalClass;
import Web.Utils.Enum.BotaoEnum;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author matheusdsl
 */
@Controller
public class ModalController {

    private ModalClass model;

    public ModalController() {
        model = new ModalClass();
    }

    @RequestMapping(value="ModalAtencao", produces = "text/html; charset=UTF8")
    @ResponseBody
    public ResponseEntity<String> ModalAtencao(String corpo) {
        model.setTitulo("Atenção");
        model.setCorpo(corpo);
        BotaoEnum btns[] = {BotaoEnum.Cancelar, BotaoEnum.Ok};
        model.setBtns(btns);
        ResponseEntity<String> json = new JsonHelper<ModalClass>().ToJson(model);
        return json;
    }

}
