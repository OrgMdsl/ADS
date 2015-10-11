var Util = (function () {

    function Util() {
    }

    Util.IsNull = function (obj) {
        if (typeof obj === "undefined" || obj === null)
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
    
    return Util;
}());