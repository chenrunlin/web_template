var jsonChilds = [];
$(function () {
    // Url编码
    $("#btnJson").click(function () {
        var text = $("#txtSourceJson").val();
        if (text == "") {
            error("请填写要格式化的内容");
        }
        else {
            $("#txtDestJson").val(formatJson(text, { newlineAfterColonIfBeforeBraceOrBracket: false, spaceAfterColon: false }));
        }
    });

    $("#btnCopyJson").click(function () {
        var text = $("#txtDestJson").val();
        if (text != "") {
        }
    });
    
    $("#btnRegexMatch").click(function () {
        $("#txtRegexResult").val("");
        var pattern = $("#txtRegexPattern").val().trim();
        var content = $("#txtRegexContent").val().trim();
        var ignoreCase = "";
        if ($("#chkIgnoreCase").is(":checked")) {
            ignoreCase = "i";
        }
        if (pattern == "") {
            error("请填写正则");
            return;
        }
        else if (content == "") {
            error("请填写内容");
            return;
        }
        else {
            var reg = new RegExp(pattern, "g" + ignoreCase);
            var arr = reg.exec(content);
            var text = '';
            if (arr) {
                $("#txtRegexTip").val("共 " + arr.length + " 个匹配项");
                for (var i = 0; i < arr.length; i++) {
                    text += ("$" + i + " -> " + arr[i]) + "\r\n";
                }
            }
            else {
                $("#txtRegexTip").val("没有匹配结果，请检查正则");
                return;
            }
            $("#txtRegexResult").val(text);
        }
    });


    // Url编码
    $("#btnUrlEncode").click(function () {
        var text = $("#txtSourceUrl").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            $("#txtDestUrl").val(encodeURIComponent(text).toLowerCase());
        }
    });

    // Url解码
    $("#btnUrlDecode").click(function () {
        var text = $("#txtDestUrl").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            $("#txtSourceUrl").val(decodeURIComponent(text));
        }
    });

    // Html编码
    $("#btnHtmlEncode").click(function () {
        var text = $("#txtSourceHtml").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            $("#txtDestHtml").val(htmlencode(text));
        }
    });

    // Html解码
    $("#btnHtmlDecode").click(function () {
        var text = $("#txtDestHtml").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            $("#txtSourceHtml").val(htmldecode(text));
        }
    });

    // Base64编码
    $("#btnBase64Encode").click(function () {
        var text = $("#txtSourceBase64").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var b = new Base64();
            $("#txtDestBase64").val(b.encode(text));
        }
    });

    // Base64解码
    $("#btnBase64Decode").click(function () {
        var text = $("#txtDestBase64").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            var b = new Base64();
            $("#txtSourceBase64").val(b.decode(text));
        }
    });

    // MD5
    $("#btnMd5").click(function () {
        var text = $("#txtSourceMd5").val();
        if (text == "") {
            error("请填写要加密的内容");
        }
        else {
            var half = "32";
            if ($("#rad16").is(":checked")) {
                half = "16";
            }
            callApi("/web_template/tools/md5", { "text": text, "half": half }, function (slt) {
                $("#txtDestMd5").val(slt);
            });
        }
    });

    // UUID
    $("#btnGetUuid").click(function () {
        callApi("/web_template/tools/uuid", null, function (slt) {
            $("#txtSourceUuid").val(slt);
        });
    });

    // 半角转全角
    $("#btnGetDbc").click(function () {
        var text = $("#txtSourceDbc").val();
        if (text == "") {
            error("请填写要转换的字符");
        }
        else {
            $("#txtDestDbc").val(ToDBC(text));
        }
    });

    // 全角转半角
    $("#btnGetDbcBack").click(function () {
        var text = $("#txtDestDbc").val();
        if (text == "") {
            error("请填写要转换的字符");
        }
        else {
            $("#txtSourceDbc").val(ToCDB(text));
        }
    });


    // 大小写转换
    $("#btnGetUpper").click(function () {
        var text = $("#txtSourceUpper").val();
        if (text == "") {
            error("请填写要转换大写的内容");
        }
        else {
            $("#txtDestUpper").val(text.toUpperCase());
        }
    });

    $("#btnGetLower").click(function () {
        var text = $("#txtSourceUpper").val();
        if (text == "") {
            error("请填写要转换小写的内容");
        }
        else {
            $("#txtDestUpper").val(text.toLowerCase());
        }
    });

    // 字符长度
    $("#btnGetLen").click(function () {
        var text = $("#txtSourceLen").val();
        if (text == "") {
            error("请填写要计算长度的字符");
        }
        else {
            var re = /[\u4E00-\u9FA5]/g;
            var len = text.match(re).length;
            $(".length-tip").show().text("字符长度：" + text.length + "，汉字数量：" + len);
        }
    });

    // 条形码
    $("#btnBarcode").click(function () {
        var type = $("#selType").val();
        var code = $("#txtCode").val();
        var width = $("#txtWidth").val();
        var height = $("#txtHeight").val();
        var isTrans = $("#chkTrans").is(":checked");
        if (code == "") {
            error("请填写要编码的内容");
        }
        else {
            var url = "/fun/barcode?type=" + type + "&code=" + code + "&width=" + width + "&height=" + height + "&isTrans=" + isTrans;
            url = encodeURI(url);
            $("#imgPreview").attr("src", url);
        }
    });

    // ASCII编码
    $("#btnAsciiEncode").click(function () {
        var text = $("#txtSourceAscii").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var a = new Ascii();
            $("#txtDestAscii").val(a.encode(text));
        }
    });

    // ASCII解码
    $("#btnAsciiDecode").click(function () {
        var text = $("#txtDestAscii").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            var a = new Ascii();
            $("#txtSourceAscii").val(a.decode(text));
        }
    });

    // UTF8编码
    $("#btnUrlEncodeUtf8").click(function () {
        var text = $("#txtSourceUrlUtf8").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var u = new UTF8();
            $("#txtDestUrlUtf8").val(u.encode(text));
        }
    });

    // UTF8解码
    $("#btnUrlDecodeUtf8").click(function () {
        var text = $("#txtDestUrlUtf8").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var u = new UTF8();
            $("#txtSourceUrlUtf8").val(u.decode(text));
        }
    });

    // Unicode编码
    $("#btnUnicodeEncode").click(function () {
        var text = $("#txtSourceUnicode").val();
        if (text == "") {
            error("请填写要编码的内容");
        }
        else {
            var u = new Unicode()
            $("#txtDestUnicode").val(u.encode(text));
        }
    });

    // Unicode解码
    $("#btnUnicodeDecode").click(function () {
        var text = $("#txtDestUnicode").val();
        if (text == "") {
            error("请填写要解码的内容");
        }
        else {
            var u = new Unicode()
            $("#txtSourceUnicode").val(u.decode(text));
        }
    });

    // json转实体
    $("#btnJsonEntity").click(function () {
        var text = $("#txtSourceJsonEntity").val();
        var cate = $("#selJsonCate").val();
        if (text == "") {
            error("请填写要转换的JSON");
        }
        else {
            var obj = eval("(" + text + ")");
            if (cate == "C#") {
                var sb = extractJson("Root", obj);
                while (jsonChilds != null && jsonChilds.length > 0) {
                    var item = jsonChilds.pop();
                    sb += "\r\n\r\n" + extractJson(item.name, item.value);
                }
                $("#txtDestJsonEntity").val(sb);
            }
            else if (cate == "Java") {
                var sb = extractJavaJson("Root", obj);
                while (jsonChilds != null && jsonChilds.length > 0) {
                    var item = jsonChilds.pop();
                    sb += "\r\n\r\n" + extractJavaJson(item.name, item.value);
                }
                $("#txtDestJsonEntity").val(sb);
            }
        }
    });

    // 字符转实体
    $("#btnStr").click(function () {
        var text = $("#txtSourceStr").val();
        var cate = $("#selStrCate").val();
        if (text == "") {
            error("请填写要转换的内容");
        }
        else {
            var arr = text.split(/,|，/);
            if (arr != null && arr.length > 0) {
                var sb = "public class Root";
                sb += "\r\n{";
                var props = [];
                for (var i = 0; i < arr.length; i++) {
                    var item = arr[i];
                    var name = item;
                    var type = "string";
                    if (/(\w+)\((\w)+\)/.test(item)) {
                        var t = /(\w+)\((\w)+\)/.exec(item);
                        name = t[1]
                        if (cate == "C#") {
                            type = getFieldType(t[2]);
                        }
                        else if (cate == "Java") {
                            type = getJavaFieldType(t[2]);
                        }
                    }
                    if (cate == "C#") {
                        sb += ((i > 0 ? "\r\n" : "") + "\r\n\tpublic " + type + " " + name + " { get; set; }");
                    }
                    else if (cate == "Java") {
                        if (type == "string") {
                            type = "String";
                        }
                        sb += (i > 0 ? "\r\n" : "") + getJavaEntity(type, name);
                        props.push({ "type": type, "name": name });
                    }
                }
                for (var p in props) {
                    sb += getJavaPropEntity(props[p].type, props[p].name);
                }
                sb += "\r\n}";
                $("#txtDestStr").val(sb);
            }
            else {
                error("生成失败，请检查所填字符串是否符合规则");
            }
        }
    });

   
    // 二进制转换
    $(".btnCal").click(function () {
        var val = $(this).attr("data-val");
        switch (val) {
            case "10":
                var text = $("#txt10").val();
                if (text == "") {
                    error("请填写十进制值");
                }
                else {
                    $("#txt2").val(parseFloat(text, 10).toString(2));
                    $("#txt8").val(parseFloat(text, 10).toString(8));
                    $("#txt16").val(parseFloat(text, 10).toString(16));
                }
                break;
            case "2":
                var text = $("#txt2").val();
                if (text == "") {
                    error("请填写二进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 2).toString(10));
                    $("#txt8").val(parseInt(text, 2).toString(8));
                    $("#txt16").val(parseInt(text, 2).toString(16));
                }
                break;
            case "8":
                var text = $("#txt8").val();
                if (text == "") {
                    error("请填写八进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 8).toString(10));
                    $("#txt2").val(parseInt(text, 8).toString(2));
                    $("#txt16").val(parseInt(text, 8).toString(16));
                }
                break;
            case "16":
                var text = $("#txt16").val();
                if (text == "") {
                    error("请填写十六进制值");
                }
                else {
                    $("#txt10").val(parseInt(text, 16).toString(10));
                    $("#txt2").val(parseInt(text, 16).toString(2));
                    $("#txt8").val(parseInt(text, 16).toString(8));
                }
                break;
        }
    });

    // 时间转换
    $(".btnCalTime").click(function () {
        var val = $(this).attr("data-val");
        switch (val) {
            case "day":
                var text = $("#txtDay").val();
                if (text == "") {
                    error("请填写天值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtHour").val(num * 24);
                    $("#txtMinute").val(num * 24 * 60);
                    $("#txtSecond").val(num * 24 * 60 * 60);
                    $("#txtMillisecond").val(num * 24 * 60 * 60 * 1000);
                }
                break;
            case "hour":
                var text = $("#txtHour").val();
                if (text == "") {
                    error("请填写小时值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 24).toFixed(4)));
                    $("#txtMinute").val(extractTime(num * 60));
                    $("#txtSecond").val(extractTime(num * 60 * 60));
                    $("#txtMillisecond").val(extractTime(num * 60 * 60 * 1000));
                }
                break;
            case "minute":
                var text = $("#txtMinute").val();
                if (text == "") {
                    error("请填写分钟值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 60).toFixed(4)));
                    $("#txtSecond").val(extractTime(num * 60));
                    $("#txtMillisecond").val(extractTime(num * 60 * 1000));
                }
                break;
            case "second":
                var text = $("#txtSecond").val();
                if (text == "") {
                    error("请填写秒值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 60 / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 60 / 60).toFixed(4)));
                    $("#txtMinute").val(extractTime((num / 60).toFixed(4)));
                    $("#txtMillisecond").val(extractTime(num * 1000));
                }
                break;
            case "millisecond":
                var text = $("#txtMillisecond").val();
                if (text == "") {
                    error("请填写毫秒值");
                }
                else {
                    var num = parseFloat(text);
                    $("#txtDay").val(extractTime((num / 1000 / 60 / 60 / 24).toFixed(4)));
                    $("#txtHour").val(extractTime((num / 1000 / 60 / 60).toFixed(4)));
                    $("#txtMinute").val(extractTime((num / 1000 / 60).toFixed(4)));
                    $("#txtSecond").val(extractTime(num / 1000));
                }
                break;
        }
    });

    // 日期转时间戳
    $("#btnTransUnix").click(function () {
        var text = $("#txtSourceUnix").val();
        if (text == "") {
            error("请填写要转换的时间");
        }
        else {
            try {
                var time = Date.parse(text);
                if (!isNaN(time)) {
                    $("#txtDestUnix").val(time / 1000);
                }
                else {
                    $("#txtDestUnix").val("");
                    error("时间格式不正确");
                }
            }
            catch (ex) {
                error(ex);
            }
        }
    });

    // 时间戳转日期
    $("#btnTransDate").click(function () {
        var text = $("#txtDestUnix").val();
        if (text == "") {
            error("请填写要转换的时间戳");
        }
        else {
            try {
                var stamp = parseFloat(text);
                if (stamp < 0) {
                    error("时间戳格式不正确");
                }
                else {
                    var newDate = new Date();
                    newDate.setTime(stamp * 1000);
                    $("#txtSourceUnix").val(newDate.format('yyyy-MM-dd hh:mm:ss'));
                }
            }
            catch (ex) {
                error(ex);
            }
        }
    });
});

// css压缩格式化
function cssCode(obj) {
    this.init = function () {
        var code = obj.val();
        if (!this.code || this.code == "") {
            this.code = code;
            this.oldLength = code.length;
        }
        code = code.replace(/(\n|\t|\s)*/ig, '$1');
        code = code.replace(/\n|\t|\s(\{|\}|\,|\:|\;)/ig, '$1');
        code = code.replace(/(\{|\}|\,|\:|\;)\s/ig, '$1');
        return code;
    }
    this.showTip = function (text) {
        $(".compress-tip").show().text(text);
    }
    this.closeTip = function () {
        $(".compress-tip").hide();
    }
    this.compress = function () {
        var code = this.init();
        var newLength = code.length;
        this.showTip("压缩前：" + this.oldLength + ", 压缩后：" + newLength + ", 压缩率：" + (Math.round(newLength / this.oldLength * 1000) / 10) + '%')
        return code;
    }
    this.format = function () {
        var code = this.init();
        code = code.replace(/(\{)/ig, ' $1');
        code = code.replace(/(\{|\;)/ig, '$1\n\t');
        code = code.replace(/\t*(\})/ig, '$1\n');
        code = code.replace(/(\*\/)/ig, '$1\n');
        this.closeTip();
        return code;
    }
    this.formatOver = function () {
        var code = this.init();
        code = code.replace(/(\})/ig, '$1\n');
        code = code.replace(/(\*\/)/ig, '$1\n');
        this.closeTip();
        return code;
    }
    this.recover = function () {
        this.closeTip();
        return (this.code) ? this.code : obj.value;
    }
}

// 字符串根据字符返回类型
function getFieldType(t) {
    var slt = "string";
    switch (t) {
        case "i":
            slt = "int";
            break;
        case "s":
            slt = "string";
            break;
        case "d":
            slt = "DateTime";
            break;
        case "b":
            slt = "bool";
            break;
    }
    return slt;
}

function getJavaFieldType(t) {
    var slt = "String";
    switch (t) {
        case "i":
            slt = "int";
            break;
        case "s":
            slt = "String";
            break;
        case "d":
            slt = "Date";
            break;
        case "b":
            slt = "boolean";
            break;
    }
    return slt;
}

// json转实体
function extractJson(title, obj) {
    var sb = "public class " + title;
    sb += "\r\n{";
    var i = 0;
    for (var name in obj) {
        var val = obj[name];
        var type = typeof (val);
        if (type == "number" || type == "string" || type == "boolean") {
            if (type == "number") {
                type = "int";
            }
            if (type == "boolean") {
                type = "bool";
            }
            sb += (i > 0 ? "\r\n" : "") + "\r\n\tpublic " + type + " " + name + " { get; set; }";
        }
        else {
            if (val.length == undefined) {
                sb += (i > 0 ? "\r\n" : "") + "\r\n\tpublic " + name + " " + name + " { get; set; }";
                jsonChilds.push({ "name": name, "value": val });
            }
            else {
                sb += (i > 0 ? "\r\n" : "") + "\r\n\tpublic List<" + name + "> " + name + " { get; set; }";
                jsonChilds.push({ "name": name, "value": val[0] });
            }
        }
        i++;
    }
    sb += "\r\n}";
    return sb;
}

function extractJavaJson(title, obj) {
    var sb = "public class " + title;
    sb += "\r\n{";
    var i = 0;
    var props = [];
    for (var name in obj) {
        var val = obj[name];
        var type = typeof (val);
        if (type == "number" || type == "string" || type == "boolean") {
            if (type == "number") {
                type = "int";
            }
            if (type == "string") {
                type = "String";
            }
            if (type == "boolean") {
                type = "bool";
            }
            sb += (i > 0 ? "\r\n" : "") + getJavaEntity(type, name);
            props.push({ "type": type, "name": name });
        }
        else {
            if (val.length == undefined) {
                sb += (i > 0 ? "\r\n" : "") + getJavaEntity(name, name);
                props.push({ "type": name, "name": name });
                jsonChilds.push({ "name": name, "value": val });
            }
            else {
                sb += (i > 0 ? "\r\n" : "") + getJavaEntity("List<" + name + ">", name);
                props.push({ "type": "List<" + name + ">", "name": name });
                jsonChilds.push({ "name": name, "value": val[0] });
            }
        }
        i++;
    }
    for (var p in props) {
        sb += getJavaPropEntity(props[p].type, props[p].name);
    }
    sb += "\r\n}";
    return sb;
}

function getJavaEntity(type, name) {
    var sb = "";
    sb += "\r\n\tprivate " + type + " " + name + ";";
    return sb;
}

function getJavaPropEntity(type, name) {
    var sb = "";
    name = nameCase(name);
    sb += "\r\n\r\n\tpublic " + type + " get" + name + "(){";
    sb += "\r\n\t\treturn this." + name + ";";
    sb += "\r\n\t}";
    sb += "\r\n\tpublic void set" + name + "(" + type + " " + name + "){";
    sb += "\r\n\t\tthis." + name + " = " + name + ";";
    sb += "\r\n\t}";
    return sb;
}

function nameCase(name) {
    var str = "";
    for (var i = 0; i < name.length; i++) {
        if (i == 0) {
            str += name[i].toUpperCase();
        }
        else {
            str += name[i].toLowerCase();
        }
    }
    return str;
}

// 时间转换优化
function extractTime(text) {
    var slt = text;
    if (text.toString().indexOf(".") > 0) {
        var arr = text.toString().split(".");
        if (parseInt(arr[1]) == 0) {
            slt = arr[0];
        }
    }
    return slt;
}


function formatJson(json, options) {
    var reg = null,
		formatted = '',
		pad = 0,
		PADDING = '    '; // one can also use '\t' or a different number of spaces

    // optional settings
    options = options || {};
    // remove newline where '{' or '[' follows ':'
    options.newlineAfterColonIfBeforeBraceOrBracket = (options.newlineAfterColonIfBeforeBraceOrBracket === true) ? true : false;
    // use a space after a colon
    options.spaceAfterColon = (options.spaceAfterColon === false) ? false : true;

    // begin formatting...
    if (typeof json !== 'string') {
        // make sure we start with the JSON as a string
        json = JSON.stringify(json);
    } else {
        // is already a string, so parse and re-stringify in order to remove extra whitespace
        json = JSON.parse(json);
        json = JSON.stringify(json);
    }

    // add newline before and after curly braces
    reg = /([\{\}])/g;
    json = json.replace(reg, '\r\n$1\r\n');

    // add newline before and after square brackets
    reg = /([\[\]])/g;
    json = json.replace(reg, '\r\n$1\r\n');

    // add newline after comma
    reg = /(\,)/g;
    json = json.replace(reg, '$1\r\n');

    // remove multiple newlines
    reg = /(\r\n\r\n)/g;
    json = json.replace(reg, '\r\n');

    // remove newlines before commas
    reg = /\r\n\,/g;
    json = json.replace(reg, ',');

    // optional formatting...
    if (!options.newlineAfterColonIfBeforeBraceOrBracket) {
        reg = /\:\r\n\{/g;
        json = json.replace(reg, ':{');
        reg = /\:\r\n\[/g;
        json = json.replace(reg, ':[');
    }
    if (options.spaceAfterColon) {
        reg = /\:/g;
        json = json.replace(reg, ': ');
    }

    $.each(json.split('\r\n'), function (index, node) {
        var i = 0,
			indent = 0,
			padding = '';

        if (node.match(/\{$/) || node.match(/\[$/)) {
            indent = 1;
        } else if (node.match(/\}/) || node.match(/\]/)) {
            if (pad !== 0) {
                pad -= 1;
            }
        } else {
            indent = 0;
        }

        for (i = 0; i < pad; i++) {
            padding += PADDING;
        }

        formatted += padding + node + '\r\n';
        pad += indent;
    });
    formatted = formatted.replace(/^\s+/, '');
    return formatted;
};

function htmlencode(s) {
    var div = document.createElement('div');
    div.appendChild(document.createTextNode(s));
    return div.innerHTML;
}
function htmldecode(s) {
    var div = document.createElement('div');
    div.innerHTML = s;
    return div.innerText || div.textContent;
}

function Base64() {

    // private property
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    // public method for encoding
    this.encode = function (input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;
        input = _utf8_encode(input);
        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
			_keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
			_keyStr.charAt(enc3) + _keyStr.charAt(enc4);
        }
        return output;
    }

    // public method for decoding
    this.decode = function (input) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < input.length) {
            enc1 = _keyStr.indexOf(input.charAt(i++));
            enc2 = _keyStr.indexOf(input.charAt(i++));
            enc3 = _keyStr.indexOf(input.charAt(i++));
            enc4 = _keyStr.indexOf(input.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = _utf8_decode(output);
        return output;
    }

    // private method for UTF-8 encoding
    _utf8_encode = function (string) {
        string = string.replace(/\r\n/g, "\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            } else if ((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            } else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }

        }
        return utftext;
    }

    // private method for UTF-8 decoding
    _utf8_decode = function (utftext) {
        var string = "";
        var i = 0;
        var c = c1 = c2 = 0;
        while (i < utftext.length) {
            c = utftext.charCodeAt(i);
            if (c < 128) {
                string += String.fromCharCode(c);
                i++;
            } else if ((c > 191) && (c < 224)) {
                c2 = utftext.charCodeAt(i + 1);
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = utftext.charCodeAt(i + 1);
                c3 = utftext.charCodeAt(i + 2);
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return string;
    }
}

function UTF8() {
    this.encode = function (str) {
        var temp = "", rs = "";
        for (var i = 0, len = str.length; i < len; i++) {
            temp = str.charCodeAt(i).toString(16);
            rs += "\\u" + new Array(5 - temp.length).join("0") + temp;
        }
        return rs;
    }
    this.decode = function (str) {
        return str.replace(/(\\u)(\w{4}|\w{2})/gi, function ($0, $1, $2) {
            return String.fromCharCode(parseInt($2, 16));
        });
    }
}

function Unicode() {
    this.encode = function (str) {
        var res = [];
        for (var i = 0; i < str.length; i++)
            res[i] = ("00" + str.charCodeAt(i).toString(16)).slice(-4);
        return "\\u" + res.join("\\u");
    }
    this.decode = function (str) {
        str = str.replace(/\\/g, "%");
        return unescape(str);
    }
}

function Ascii() {
    this.encode = function (content) {
        var result = '';
        for (var i = 0; i < content.length; i++)
            result += '&#' + content.charCodeAt(i) + ';';
        return result;
    }
    this.decode = function (content) {
        var code = content.match(/&#(\d+);/g);
        result = '';
        for (var i = 0; i < code.length; i++)
            result += String.fromCharCode(code[i].replace(/[&#;]/g, ''));
        return result;
    }
}