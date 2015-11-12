
var Util = (function () {

    function Util() {
    }

    Util.IsNull = function (obj) {
        if (!obj || obj === null)
            return true;
        return false;
    };

    Util.IsEmpty = function (txt) {
        if (this.IsNull(txt) || txt.length <= 0)
            return true;
        return false;
    };

    Util.SelectByName = function (name) {
        return $("[name='" + name + "']");
    };

    Util.HasClass = function (element, cls) {
        return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;
    };

    Util.VerifyInstance = function (classe) {
        if (!(this instanceof classe))
            return new classe();
    };

    Util.InputColor = {
        Vermelho: function (element) {
            element.addClass("red");
            /* element.css({
             'border': '1px solid #ee4545',
             'box-shadow': '0px 0px 3px 0px #ff0000'
             });
             */
            element.on("focus", function () {
                element.removeClass("red");
            });
        }

    };

    Util.ValueExist = function (strd) {
        
        existe = false;
        $('tr').each(function () {
            if ($('td:nth(1)', $(this)).html() === strd) {
                existe = true;
            }
        });
        return existe;
    };

    Util.GetBase64Image = function (imgElem) {
        var canvas = document.createElement("canvas");
        canvas.width = imgElem.clientWidth;
        canvas.height = imgElem.clientHeight;
        var ctx = canvas.getContext("2d");
        ctx.drawImage(imgElem, 0, 0);
        var dataURL = canvas.toDataURL("image/png");
        return dataURL.replace(/^data:image\/(png|jpg);base64,/, "");
    };

    return Util;
}());