package com.kodilla.bytecode.reflection.academy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/academy")
public class AcademyController {

    @GetMapping(path = "/students")
    public ResponseEntity<Map<Integer, String>> getStudentsMap(@RequestParam(defaultValue = "20") int n,
                                                @RequestParam(defaultValue = "10") int z)
            throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Map<Integer, String> students = new HashMap();

        var academyControllerHelper = new AcademyControllerHelper();
        Method generateRandomStringMethod
                = AcademyControllerHelper.class.getDeclaredMethod("generateRandomString", new Class[]{int.class});
        generateRandomStringMethod.setAccessible(true);

        Field indexNumberField = Student.class.getDeclaredField("indexNumber");
        indexNumberField.setAccessible(true);

        for (int i=0; i<n; i++) {
            var generatedStudent = new Student((String)generateRandomStringMethod.invoke(academyControllerHelper, z));
            students.put(
                    generatedStudent.hashCode(),
                    (String) indexNumberField.get(generatedStudent)
            );
        }

        return ResponseEntity.ok(students);
    }
}
