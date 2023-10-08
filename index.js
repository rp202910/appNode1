// const http=require('http');
// const data=require('./data');
// http.createServer((req,res)=>{
//     res.writeHead(200,{'Content-Type':'application\json'});
//     res.write(JSON.stringify(data));
//     res.end();
// }).listen(4000,()=>{
//     console.log("Server is running on port 4000");
// });

const cors = require('cors');
const express = require('express');
const app = express();
const { filterRequest, filterRequest1 } = require('./middleware');
const {userRouter}= require('./users')



app.get("/", (req, res) => {
    res.send("Welcome");
})
app.use("/users", userRouter)
app.use(cors());
//app.use("/login", router);

app.use("/purchase", filterRequest);

app.get("*", (req, res) => {
    res.send("You hit the wrong place");
})

app.listen(4000);
console.log(`Server started on the port: ${4000}`)

//For applying the middleware to specific route then we can do:
// route.get("/login",filterRequest,(req,res)=>{
//     res.send("Using the site")
// })