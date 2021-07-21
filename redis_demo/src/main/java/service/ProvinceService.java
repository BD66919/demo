package service;


import java.io.IOException;
import java.util.*;

public interface ProvinceService {
    public List<String> findAll();
    public String findAllJson() throws IOException;
}
