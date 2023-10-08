const express = require('express');
const app = express();

const filterRequest=(req,res,next)=>{
    if(req.query.name==="roshan"){
      next();
    }else{
        console.log("can't access")
        res.send("You can't access");
    }
}
const filterRequest1=(req,res,next)=>{
    console.log(`${JSON.stringify(req.query.name)}`);
    if(req.query.name==="keshav"){
        console.log('Purchase the item');
       next();
    }else{
        res.send("You can't access");
    }
}
const headersMiddleware=(req,res,next)=>{
    res.header("Access-Control-Allow-Origin", req.headers.origin);
    next();
}

module.exports={filterRequest,filterRequest1,headersMiddleware};