function prod(...args){
    if (args.length == 0) return;
    let result = 1;
    for (let arg of args){
         result *= arg;
    }
    return result;
}


console.log(prod());