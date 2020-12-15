package po.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

@CrossOrigin("*")
@RestController
public class WebsiteMapping {

    @GetMapping(value = "/productDetails")
    public ResponseEntity<String> getProductDetails(@RequestParam int id) {
        String html = fileToString(new File("src\\main\\resources\\static\\product-details.html"));
        html = html.replace("---id---", "" + id);

        return ResponseEntity.ok().contentType(MediaType.TEXT_HTML).body(html);
    }

    private String fileToString(File file) {
        char[] string = new char[0];
        try {
            Reader reader = new FileReader(file);
            string = new char[(int) file.length()];
            reader.read(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new String(string);
    }
}
