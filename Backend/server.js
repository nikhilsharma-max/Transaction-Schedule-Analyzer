const express = require("express");
const cors = require("cors");
const path = require("path");
const app = express();
const dotenv = require("dotenv");
dotenv.config();
app.use(cors());
app.use(express.json());
const port =  8080;

const analyzeRoute =
  require("./routes/analyze");

console.log(process.cwd());

const javaPath =
  path.join(
    __dirname,
    "../Transaction-Schedule-Analyzer-1/src"
  );

app.get("/", (req, res) => {
  res.json({
    status: "ok",
    service: "Transaction Schedule Analyzer API"
  });
});
app.use("/analyze", analyzeRoute);

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
