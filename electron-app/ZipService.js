var file_system = require('fs');
const archiver = require('archiver');

/**
   * @param {String} sourceDir: /Users/will/Desktop/test
   * @param {String} outPath: /Users/will/Desktop/test.zip
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

  zipDirectory();