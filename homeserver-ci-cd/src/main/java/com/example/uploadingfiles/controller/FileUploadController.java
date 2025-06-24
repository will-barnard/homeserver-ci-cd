package com.example.uploadingfiles.controller;

import com.example.uploadingfiles.exception.StorageFileNotFoundException;
import com.example.uploadingfiles.model.StorageProperties;
import com.example.uploadingfiles.service.FileSystemStorageService;
import com.example.uploadingfiles.service.ScriptRunnerService;
import com.example.uploadingfiles.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @Value("${willBarnard}")
    private String willBarnard;

    @Value("${kitchenJamDist}")
    private String kitchenJamDist;

    @Value("${kitchenJamJar}")
    private String kitchenJamJar;

    @Value("${trainTrackerDist}")
    private String trainTrackerDist;

    @Value("${trainTrackerBackend}")
    private String trainTrackerBackend;

    @Value("${trainTrackerLsService}")
    private String trainTrackerLsService;

    @Value("${trainTrackerRunService}")
    private String trainTrackerRunService;

    @Value("${virtualVibesDist}")
    private String virtualVibesDist;

    @Value("${virtualVibesJar}")
    private String virtualVibesJar;

    @Value("${cashCrittersDist}")
    private String cashCrittersDist;

    @Value("${bttbDist}")
    private String bttbDist;

    @Value("${bttbJar}")
    private String bttbJar;

    @Value("${antonio}")
    private String antonio;

    @Value("${chessApi}")
    private String chessApi;

    @Value("${chessLan}")
    private String chessLan;

    @Value("${chessVpn}")
    private String chessVpn;

    @Value("${homeserver}")
    private String homeserver;

    @Value("${periodicTable}")
    private String periodicTable;

    @Value("${vocabDist}")
    private String vocabDist;

    @Value("${vocabJar}")
    private String vocabJar;

    @Value("${nateDist}")
    private String nateDist;

    @Value("${nateJar}")
    private String nateJar;

    @Value("${deployKitchenJam}")
    private String deployKitchenJamScript;

    @Value("${deployTrainTrackerBackend}")

    private String deployTrainTrackerBackendScript;

    @Value("${deployTrainTrackerLs}")
    private String deployTrainTrackerLsScript;

    @Value("${deployTrainTrackerRun}")
    private String deployTrainTrackerRunScript;

    @Value("${deployVirtualVibes}")
    private String deployVirtualVibesScript;

    @Value("${deployBttb}")
    private String deployBttbScript;

    @Value("${deployChessArchive}")
    private String deployChessArchiveScript;

    @Value("${deployVocabBuilder}")
    private String deployVocabBuilderScript;

    @Value("${deploySingleNates}")
    private String deploySingleNatesScript;
    

    // Group: Will Barnard
    @PostMapping("/will-barnard")
    @ResponseBody
    public void willBarnardUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(willBarnard + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(willBarnard);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated will-barnard.com");
    }


    // Group: Kitchen Jam
    @PostMapping("/kitchen-jam-frontend")
    @ResponseBody
    public void kitchenJamDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(kitchenJamDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(kitchenJamDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated kitchen jam frontend");
    }

    @PostMapping("/kitchen-jam-backend")
    @ResponseBody
    public void kitchenJamJarUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(kitchenJamJar);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployKitchenJamScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for kitchen jam backend", e);
        }
        System.out.println("updated kitchen jam jar");

    }


    // Group: Train Tracker
    @PostMapping("/train-tracker-frontend")
    @ResponseBody
    public void trainTrackerDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(trainTrackerDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(trainTrackerDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated train tracker frontend");

    }

    @PostMapping("/train-tracker-backend")
    @ResponseBody
    public void trainTrackerBackendUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(trainTrackerBackend);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployTrainTrackerBackendScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for train tracker backend", e);
        }
        System.out.println("updated train tracker backend jar");

    }

    @PostMapping("/train-tracker-ls")
    @ResponseBody
    public void trainTrackerLsUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(trainTrackerLsService);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployTrainTrackerLsScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for train tracker ls", e);
        }
        System.out.println("updated train tracker ls jar");

    }

    @PostMapping("/train-tracker-run")
    @ResponseBody
    public void trainTrackerRunUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(trainTrackerRunService);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployTrainTrackerRunScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for train tracker run", e);
        }
        System.out.println("updated train tracker rs jar");

    }


    // Group: Virtual Vibes
    @PostMapping("/virtual-vibes-frontend")
    @ResponseBody
    public void virtualVibesDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(virtualVibesDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(virtualVibesDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated virtual vibes frontend");

    }

    @PostMapping("/virtual-vibes-backend")
    @ResponseBody
    public void virtualVibesBackendUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(virtualVibesJar);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployVirtualVibesScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for virtual vibes backend", e);
        }
        System.out.println("updated virtual vibes jar");

    }


    // Group: Cash Critters
    @PostMapping("/cash-critters")
    @ResponseBody
    public void cashCrittersDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(cashCrittersDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(cashCrittersDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated cash critters frontend");

    }


    // Group: BTTB
    @PostMapping("/bttb-frontend")
    @ResponseBody
    public void bttbDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(bttbDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(bttbDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated bttb frontend");

    }

    @PostMapping("/bttb-backend")
    @ResponseBody
    public void bttbBackendUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(bttbJar);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployBttbScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for bttb backend", e);
        }
        System.out.println("updated bttb jar");

    }


    // Group: Antonio
    @PostMapping("/antonio")
    @ResponseBody
    public void antonioUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(antonio + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(antonio);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated antonio");

    }

    
    // Group: Chess
    @PostMapping("/chess-frontend")
    @ResponseBody
    public void chessLanUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(chessLan + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(chessLan);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated chess lan");

    }

    @PostMapping("/chess-vpn")
    @ResponseBody
    public void chessVpnUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(chessVpn + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(chessVpn);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated chess vpn");

    }

    @PostMapping("/chess-api")
    @ResponseBody
    public void chessApiUpload(@RequestParam("file") MultipartFile file) {

        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(chessApi);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployChessArchiveScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for chess archive", e);
        }
        System.out.println("updated chess archive");

    }


    // Group: Periodic Table
    @PostMapping("/periodic-table")
    @ResponseBody
    public void periodicTableDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(periodicTable + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(periodicTable);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated periodic table frontend");

    }


    // Group: Homeserver
    @PostMapping("/homeserver")
    @ResponseBody
    public void homeserverUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(homeserver + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(homeserver);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated homeserver");
    }

    // Group: Vocab
    @PostMapping("/vocab-frontend")
    @ResponseBody
    public void vocabDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(vocabDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(vocabDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated vocab frontend");
    }

    @PostMapping("/vocab-backend")
    @ResponseBody
    public void vocabJarUpload(@RequestParam("file") MultipartFile file) {
        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(vocabJar);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deployVocabBuilderScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for vocab backend", e);
        }
        System.out.println("updated vocab jar");
    }


    // Group: Nate
    @PostMapping("/nate-frontend")
    @ResponseBody
    public void nateDistUpload(@RequestParam("file") MultipartFile file) {
        StorageProperties properties = new StorageProperties(nateDist + "/foo");
        FileSystemStorageService service = new FileSystemStorageService();
        service.setStorageProperties(properties);
        service.deleteAll();

        StorageProperties properties2 = new StorageProperties(nateDist);
        service.setStorageProperties(properties2);
        service.store(file);
        service.unzip(file.getOriginalFilename());
        System.out.println("updated nate frontend");
    }

    @PostMapping("/nate-backend")
    @ResponseBody
    public void nateJarUpload(@RequestParam("file") MultipartFile file) {
        FileSystemStorageService service = new FileSystemStorageService();
        StorageProperties properties = new StorageProperties(nateJar);
        service.setStorageProperties(properties);
        service.store(file);
        try {
            ScriptRunnerService.runScript(deploySingleNatesScript);
        } catch (Exception e) {
            throw new RuntimeException("Failed to execute script for nate backend", e);
        }
        System.out.println("updated nate jar");
    }

    
    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }





}
