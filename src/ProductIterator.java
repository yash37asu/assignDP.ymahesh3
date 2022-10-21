package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductIterator implements ListIterator {

    ArrayList<String> Products = new ArrayList<String>();
    int temp;
    public ProductIterator() throws IOException
    {
        File file = new File("src/ProductInfo.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String str;
        while((str = br.readLine()) != null)
        {
            Products.add(str);
        }
        br.close();
    }
    @Override
    public boolean hasNext() {
        if(temp<Products.size())
        {
            return true;
        }
        return false;
    }

    @Override
    public Object Next() {
        if(this.hasNext())
        {
            return Products.get(temp++);
        }
        return null;
    }


    @Override
    public void MoveToHead() {

    }

    @Override
    public void Remove() {

    }
}
