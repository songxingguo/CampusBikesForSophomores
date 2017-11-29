(function(){
    var cssContent = __inline('ie-lower.less');
    var injectCssFn = (function (css) {
        var headEl = document.getElementsByTagName('head')[0];
        var styleEl = document.createElement('style');
        headEl.appendChild(styleEl);

        if (styleEl.styleSheet) {
            if (!styleEl.styleSheet.disabled) {
                styleEl.styleSheet.cssText = css;
            }
        } else {
            try {
                styleEl.innerHTML = css
            } catch(e) {
                styleEl.innerText = css;
            }
        }
    });

    injectCssFn(cssContent);
    document.write(__inline('ie-lower.html'));
})();



