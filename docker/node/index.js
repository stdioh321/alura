const express = require('express')
var ip = require('ip');
var fs = require('fs');
var os = require("os");
var path = require('path');

const app = express()
const port = 3000

app.get('/', (req, res) => {
  var buffer = fs.readFileSync(path.join(__dirname + '/public/index.html'),{flag:'r'});
  var out = buffer.toString();
  out = out.replace(/\$ip/g, ip.address().toString());
  out = out.replace(/\$host/g, os.hostname());
  res.send(out);

  // res.sendFile(path.join(__dirname + '/public/index.html'));
  
  
  res.set("ip", ip.address());
  console.log(ip.address() + "\n");
});
app.get('/json', (req, res) => {
  res.json({json:"JSON"});
  
  console.log(ip.address() + "\n");
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})