package com.kodilla.bytecode.reflection.academy;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@CrossOrigin("*")
@RequestMapping("/v1/academy")
public class AcademyController {

    @GetMapping(path = "/students")
    public ResponseEntity<Map<Integer, String>> getStudentsMap(@Valid
            @RequestParam(defaultValue = "20") @Range(min = 1, max = 100) int n,
            @RequestParam(defaultValue = "10") @Range(min = 1, max = 100) int z)
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

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Map<String, String>> handleException(ConstraintViolationException exc) {
        Map<String, String> resultMap = new HashMap<>();
        String[] errorsArray = exc.getMessage().split(",");
        String[] errorArray1 = errorsArray[0].split(":");
        resultMap.put(errorArray1[0], errorArray1[1]);

        if (errorsArray.length == 2) {
            String[] errorArray2 = errorsArray[1].split(":");
            resultMap.put(errorArray2[0], errorArray2[1]);
        }

        return new ResponseEntity<>(resultMap, HttpStatus.BAD_REQUEST);
    }
}
