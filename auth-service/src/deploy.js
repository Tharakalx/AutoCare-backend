const axios = require("axios");
const fs = require("fs");
const FormData = require("form-data");

const CAMUNDA_REST_URL = "http://localhost:8080/engine-rest";

async function deployBPMN(filePath) {
  try {
    const formData = new FormData();
    formData.append("deployment-name", "loginDeployment");
    formData.append("deploy-changed-only", "true");
    formData.append("data", fs.createReadStream(filePath), {
      filename: "login.bpmn",
      contentType: "text/xml",
    });

    const response = await axios.post(`${CAMUNDA_REST_URL}/deployment/create`, formData, {
      headers: formData.getHeaders(),
    });

    console.log("Deployment successful:", response.data);
  } catch (err) {
    console.error("Deployment failed:", err.message);
  }
}

// Deploy your BPMN file
deployBPMN("./login.bpmn");
