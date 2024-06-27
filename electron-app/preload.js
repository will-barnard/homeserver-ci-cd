const { ipcRenderer } = require('electron');

window.addEventListener('DOMContentLoaded', () => {
    const replaceText = (selector, text) => {
      const element = document.getElementById(selector)
      if (element) element.innerText = text
    }
  
    for (const dependency of ['chrome', 'node', 'electron']) {
      replaceText(`${dependency}-version`, process.versions[dependency])
    }

    let test = document.getElementById("test");
    test.addEventListener("click", () => {
        ipcRenderer.send("testSend");
    })

    let kitchenJamFrontend = document.getElementById("kjfe");
    kitchenJamFrontend.addEventListener("click", () => {
        ipcRenderer.send("kjfe");
    })
    let kitchenJamBackend = document.getElementById("kjbe");
    kitchenJamBackend.addEventListener("click", () => {
        ipcRenderer.send("kjbe");
    })
    let trainTrackerFrontend = document.getElementById("ttfe");
    trainTrackerFrontend.addEventListener("click", () => {
        ipcRenderer.send("ttfe");
    })
    let trainTrackerBackend = document.getElementById("ttbe");
    trainTrackerBackend.addEventListener("click", () => {
        ipcRenderer.send("ttbe");
    })
    let trainTrackerLsService = document.getElementById("ttls");
    trainTrackerLsService.addEventListener("click", () => {
        ipcRenderer.send("ttls");
    })
    let trainTrackerRunService = document.getElementById("ttrs");
    trainTrackerRunService.addEventListener("click", () => {
        ipcRenderer.send("ttrs");
    })
    let virtualVibesFrontend = document.getElementById("vvfe");
    virtualVibesFrontend.addEventListener("click", () => {
        ipcRenderer.send("vvfe");
    })
    let virtualVibesBackend = document.getElementById("vvbe");
    virtualVibesBackend.addEventListener("click", () => {
        ipcRenderer.send("vvbe");
    })
    }
)
