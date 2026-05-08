package po;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Selectors;

import java.util.HashMap;
import java.util.Map;

import static steps.Hooks.page;


public class Click {

    public void iClickOn(Locator elementName){
        elementName.click();
    }


    public static HashMap<String, Locator> elementRegistry = new HashMap<>();

    public void registerElements() {
        elementRegistry.put("ADD_REMOVE_ELEMENTS", page.getByText("Add/Remove Elements"));
        elementRegistry.put("BASIC_AUTH", page.getByText("Basic Auth"));
    }


   public void addRemoveElements(){
        elementRegistry.put("ADD_ELEMENT", page.locator("[onclick='addElement()']"));
        elementRegistry.put("DELETE", page.locator("[onClick='deleteElement()']"));
   }




}
