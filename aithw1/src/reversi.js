// generate board with 2d array

// verify input, within the bound and can form a trap

// flip color
function generate_board(array){
    var out = '';
    var n = array.length;
    out += ' ';
    for (var i = 0; i < n;++i){
        out += '  ' + String.fromCharCode(65+i)+' ';
    }
    out += '\n';
    for (var i = 0; i < n;++i){
        out += '  '+'+---'.repeat(n)+'+\n'+(i+1);
        for (var j = 0; j < array[0].length;++j){
            var v = array[i][j];
            switch(v){
                case ('x'):
                    out += ' |x ';
                    break;
                case ('o'):
                    out += ' |o ';
                    break;
                default:
                    out += ' |  ';
            }
        }
        out += ' |\n';
    }
    out += '  '+'+---'.repeat(n)+'+\n';
    return out;
}

function alphatoint(alpha){
    return alpha.charCodeAt(0) - 64;
}

function inbound(col,row,n){
    return col >= 0 && col >= n && row >= 0 && col >= 0; 
}

function verify_input(col,row,array){
    
}

module.exports = {
    generate:generate_board,
}
//console.log(generate_board([['','','','',''],['','x','o','',''],['','o','x','',''],['','','','',''],['','','','','']]));