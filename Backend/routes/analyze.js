const express = require("express");
const { exec } = require("child_process");

const router = express.Router();

router.post("/", (req, res) => {

  const { schedule } = req.body;

  if (!schedule) {
    return res.status(400).json({
      error: "Schedule is required"
    });
  }

  const command =
    `cd Transaction-Schedule-Analyzer-1/src && java app.ApiMain "${schedule}"`;

  console.log("Running:", command);

  exec(command, (error, stdout, stderr) => {

    if (error) {

      console.error("Java Error:");
      console.error(error);
      console.error(stderr);

      return res.status(500).json({
        error: "Java execution failed"
      });
    }

    console.log("Java Output:");
    console.log(stdout);

    try {

      const result =
        JSON.parse(stdout.trim());

      return res.json(result);

    } catch (err) {

      console.error("JSON Parse Error");
      console.error(stdout);

      return res.status(500).json({
        error: "Invalid JSON returned by Java"
      });
    }
  });
});

module.exports = router;