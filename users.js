// Importing the module
const express = require("express")


const {MongoClient}=require("mongodb");
const userRouter = express.Router()
const {headersMiddleware}=require('./middleware')
userRouter.use(headersMiddleware);


let nativeClient="";
let LocalDbs="";

const init=async()=>{
    const url='mongodb://localhost:27017';
    nativeClient=await MongoClient.connect(url);
    LocalDbs=nativeClient.db("local-db").collection("curdApplication");
}
init();

userRouter.get("/create",  async (req,res,next) => {
    console.log("created");
    let {id,name}=req.query;
    await LocalDbs.insertOne({id,name});
    return res.status(200).json({ message: "Create Request" });
});
userRouter.get("/delete", async(req,res,next) => {
    try{
        let{id,name}=req.query;
        const details=await LocalDbs.deleteOne({id:id});
        if(details.deletedCount===0)
            throw new Error("Not deleted");
       return res.status(200).json({ message: "Delete Request" });
    }catch(error){
        return res.status(500).json({ message: error.message});
    }
   
})
userRouter.get("/update", async(req,res,next) => {
    let{id,name}=req.query;
    await LocalDbs.updateOne({id:id},{"$set":{name}});
    return res.status(200).json({ message: "Update Request" });
});
userRouter.get("/read", async(req,res,next) => {
    console.log("read");
    let {id}=req.query;
   const details=await LocalDbs.findOne({id:id});
   return res.status(200).json({ details });
  
});
  
module.exports = {userRouter};