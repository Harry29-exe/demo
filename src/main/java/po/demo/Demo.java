package po.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class Demo {
    private final List<TextObject> fakeDatabase = new ArrayList<>();

    public Demo() {
        fakeDatabase.add(new TextObject(1, "gfdshayiu", 2161667));
    }

    @GetMapping("/getTexts")
    public List<TextObject> getTextObjects() {
        return fakeDatabase;
    }

    @GetMapping("/textObject")
    public ResponseEntity<TextObject> getTextObjectById(int id) {
        TextObject textObject = null;
        for (TextObject object : fakeDatabase) {
            if (object.getId() == id) {
                textObject = object;
                break;
            }
        }
        if(textObject != null)
            return ResponseEntity.ok(textObject);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/textObject", consumes = "application/json")
    public void postTextObject(@RequestBody TextObject textObject) {
        fakeDatabase.add(textObject);
    }

    @DeleteMapping(value = "/secured/textObject")
    public void deleteTextObject(int id) {
        for(int i = 0; i < fakeDatabase.size(); i++) {
            if(fakeDatabase.get(i).getId() == id) {
                fakeDatabase.remove(i--);
            }
        }
    }
}
