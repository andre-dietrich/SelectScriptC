function highlight_comments(code) {
  function clear_span(match) {
    match = match.replace(/<span.*?>/g, "");
    match = match.replace(/<\/span>/g, "");
    return "<span style='color:gray'>"+match+"</span>";
  }

  return code.replace(/#(.*?)\n/g, clear_span);
}

function highlight_keywords(code) {
  keyword = [/\b([Aa][Ss])\b/g,
             /\b([Bb][Yy])\b/g,
             /\b([Cc][Oo][Nn][Nn][Ee][Cc][Tt])\b/g,
             /\b([Ee][Xx][Ii][Tt])\b/g,
             /\b([Ii][Ff])\b/g,
             /\b([Ff][Rr][Oo][Mm])\b/g,
             /\b([Gg][Rr][Oo][Uu][Pp])\b/g,
             /\b([Ll][Ii][Mm][Ii][Tt])\b/g,
             /\b([Ll][Oo][Oo][Pp])\b/g,
             /\b([Nn][Oo]\s[Cc][Yy][Cc][Ll][Ee])\b/g,
             /\b([Oo][Rr][Dd][Ee][Rr])\b/g,
             /\b([Pp][Rr][Oo][Cc]([Ee][Dd][Uu][Rr][Ee])?)\b/g,
             /\b([Ss][Ee][Ll][Ee][Cc][Tt])\b/g,
             /\b([Ss][Tt][Aa][Rr][Tt]\s[Ww][Ii][Tt][Hh])\b/g,
             /\b([Ss][Tt][Oo][Pp]\s[Ww][Ii][Tt][Hh])\b/g,
             /\b([Uu][Nn][Ii][Qq])\b/g,
             /\b([Ww][Hh][Ee][Rr][Ee])\b/g,
             /\b([Yy][Ii][Ee][Ll][Dd])\b/g,
             ];

  for (var i=0; i<keyword.length; i++) {
    code = code.replace(keyword[i], "<span style='color:red'>$1</span>");
  }

  return code;
}

function highlight_keyvalues(code) {
  keyword = [/\b([Nn][Oo][Nn][Ee])\b/g,
             /\b([Tt][Rr][Uu][Ee])\b/g,
             /\b([Ff][Aa][Ll][Ss][Ee])\b/g,
             ];

  for (var i=0; i<keyword.length; i++) {
    code = code.replace(keyword[i], "<span style='color:orange'>$1</span>");
  }

  return code;
}

function highlight_strings2(code) {
  function clear_span(match) {
    match = match.replace(/<span.*?>/g, "");
    match = match.replace(/<\/span>/g, "");
    return "<span style='color:green'>"+match+"</span>";
  }

  return code.replace(/"(.*?)"/g, clear_span);
}

function highlight_numbers(code) {
  return code.replace(/\b((0[b,o,x,B,O,X])?[0-9]+(\.[0-9]*)?)\b/g, "<span style='color:blue'>$1</span>");
}

function highlight_dollars(code) {
  return code.replace(/\$/g, "<span style='font-weight:bold'>$</span>");
}

function highlight_S2 () {
  var ca = document.getElementsByClassName('lang-s2');
  for (var i=0; i< ca.length; i++) {
    var code = ca[i].innerHTML;

    code = highlight_keywords(code);
    code = highlight_keyvalues(code);
    code = highlight_dollars(code);
    code = highlight_numbers(code);
    code = highlight_strings2(code);
    code = highlight_comments(code);

    ca[i].innerHTML = code;
  }
}
window.addEventListener("load", highlight_S2);
