
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

    return Util;
}());