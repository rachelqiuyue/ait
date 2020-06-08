var rev = require("./reversi.js");
var readlineSync = require('readline-sync');
var fs = require('fs');

//var file = process.argv[2];
const file = readlineSync.question('Input file');
fs.readFile(file, 'utf8', function(err, data) {
    if (err) {
     console.log('uh oh', err); 
    } else {
    var obj = JSON.parse(data);
    console.log(rev.generate(obj.board));
    }
   });



//console.log(rev.generate([['','','','',''],['','x','o','',''],['','o','x','',''],['','','','',''],['','','','','']]));