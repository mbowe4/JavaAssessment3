package parsing_json;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ElementCollection extends ArrayList<Element>{
    private List<Element> elementList;

    public Element findByAtomicNumber(int atomic_number) {

        try {
            elementList = ElementCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Element result = null;
        for(Element element: elementList) {
            if (element.getNumber() == atomic_number) {
                result = element;
            }
        }
        return result;
    }

    public Element findByName(String name) {
        try {
            elementList = ElementCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Element result = null;
        for(Element element: elementList) {
            if (element.getName().equals(name)) {
                result = element;
            }
        }
        return result;
    }

    public ElementCollection where(String fieldName, Object value) {
        ElementCollection elementCollection = new ElementCollection();

        try {
            elementList = ElementCollectionInitializer.generate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Element element: elementList) {
            Class cls = element.getClass();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            Method methodCall = null;

            try {
                methodCall = cls.getDeclaredMethod(methodName, null);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            try {
                if(methodCall.invoke(element, null).equals(value)) {
                    elementCollection.add(element);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return elementCollection;
    }
}
