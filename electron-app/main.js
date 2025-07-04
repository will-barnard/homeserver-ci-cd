const { app, BrowserWindow, ipcMain } = require('electron')
const path = require('node:path')
const fs = require('fs');
var archiver = require('archiver');
const FormData = require('form-data');

const api = require('./endpoints.js');
const axios = require('axios').default;
axios.defaults.baseURL = api.endpoint;
let config = {
    header : {
      'Content-Type' : 'multipart/form-data'
    }
}

const createWindow = () => {
    const win = new BrowserWindow({
      width: 800,
      height: 900,
      webPreferences: {
        preload: path.join(__dirname, 'preload.js'),
        nodeIntegration: true,
        contextIsolation: true
      }
    })
  
    win.loadFile('index.html');
}  
app.whenReady().then(() => {
    createWindow();
})

ipcMain.on("will", () => {
    sendFile(api.willFrontend, api.willDist, true)
});
ipcMain.on("kjfe", () => {
    sendFile(api.kitchenJamFrontend, api.kitchenJamDist, true)
});
ipcMain.on("kjbe", () => {
    sendFile(api.kitchenJamBackend, api.kitchenJamJar, false)
});
ipcMain.on("ttfe", () => {
    sendFile(api.trainTrackerFrontend, api.trainTrackerDist, true)
});
ipcMain.on("ttbe", () => {
    sendFile(api.trainTrackerBackend, api.trainTrackerBackendJar, false)
});
ipcMain.on("ttls", () => {
    sendFile(api.trainTrackerLsService, api.trainTrackerLsServiceJar, false)
});
ipcMain.on("ttrs", () => {
    sendFile(api.trainTrackerRunService, api.trainTrackerRunServiceJar, false)
});
ipcMain.on("vvfe", () => {
    sendFile(api.virtualVibesFrontend, api.virtualVibesDist, true)
});
ipcMain.on("vvbe", () => {
    sendFile(api.virtualVibesBackend, api.virtualVibesJar, false)
});
ipcMain.on("cash", () => {
    sendFile(api.crittersEndpoint, api.crittersDist, true)
});
ipcMain.on("bttbfe", () => {
    sendFile(api.bttbFrontend, api.bttbDist, true)
});
ipcMain.on("bttbbe", () => {
    sendFile(api.bttbBackend, api.bttbJar, false)
});
ipcMain.on("antonio", () => {
    sendFile(api.antonioFrontend, api.antonioDist, true)
});
ipcMain.on("chesslan", () => {
    sendFile(api.chessFrontend, api.chessDist, true)
});
ipcMain.on("chessvpn", () => {
    sendFile(api.chessVpn, api.chessDist, true)
});
ipcMain.on("chessapi", () => {
    sendFile(api.chessBackend, api.chessJar, false)
});
ipcMain.on("homeserver", () => {
    sendFile(api.homeserver, api.homeserverJar, false)
});
ipcMain.on("periodic", () => {
    sendFile(api.periodicTable, api.periodicTableDist, true)
});
ipcMain.on("vbfe", () => {
    sendFile(api.vocabFrontend, api.vocabDist, true)
});
ipcMain.on("vbbe", () => {
    sendFile(api.vocabBackend, api.vocabJar, false)
});
ipcMain.on("snfe", () => {
    sendFile(api.nateFrontend, api.nateDist, true)
});
ipcMain.on("snbe", () => {
    sendFile(api.nateBackend, api.nateJar, false)
});

function sendFile(endpoint, file, zip) {
    if (zip) {
        zipDirectory(file, file + ".zip")
            .then( 
                () => {
                    axios.post(endpoint, createForm(file + ".zip"), config)
                        .then(() => console.log("success"))
                }
            )
    } else {
        axios.post(endpoint, createForm(file), config)
        .then(
            () => console.log("success"))
    }
}
/**
 * @returns {Promise}
 */
function zipDirectory(sourceDir, outPath) {
    const archive = archiver('zip', { zlib: { level: 9 }});
    const stream = fs.createWriteStream(outPath);
  
    return new Promise((resolve, reject) => {
      archive
        .directory(sourceDir, false)
        .on('error', err => reject(err))
        .pipe(stream)
      ;
  
      stream.on('close', () => resolve());
      archive.finalize();
    });
}
function createForm(file) {
    const form = new FormData();
    form.append('file', fs.createReadStream(file));

    return form;
}