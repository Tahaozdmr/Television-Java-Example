import java.util.Scanner;

public class Television
{
    private int volume=5;
    void TelevisionOpen()
    {
        System.out.println("Televizyonu açmak için bir tuşa basınız.");
        Scanner scanner=new Scanner(System.in);
        var b = scanner.next();
        System.out.println("Televizyon açıldı");
    }

    int KanalSec()
    {
         System.out.println("0-59 arası bir kanal seçin");
            Scanner scanner = new Scanner(System.in);
            var kanalsec = scanner.nextLine();
            var isnumeric=isNumeric(kanalsec);
            if (!isnumeric)
            {
                System.out.println("Sayısal bir değer giriniz.");
                return Menu();
            }
            var kanalnumarası=Integer.parseInt(kanalsec);
            if (kanalnumarası < 60 && kanalnumarası > 0) {
                System.out.println("Seçilen kanal " + kanalsec);
                return Menu();
            } else {
                System.out.println("Geçersiz değer.");
                return KanalSec();
            }

    }
    boolean isNumeric(String number)
    {
        try {
            Integer.parseInt(number);
            return true;

        }
        catch (Exception e)
        {
            return false;
        }
    }
    int SesAc()
    {
        if (volume>=10)
        {
            volume--;
        }
        setVolume(getVolume() + 1);
        System.out.println("Ses seviyesi "+ getVolume());
        return 1;
    }
    int SesKis()
    {
        if (volume<=0)
        {
            volume++;
        }
        setVolume(getVolume() - 1);
        System.out.println("Ses seviyesi "+ getVolume());

        return 1;
    }
    void Kapa()
    {
        System.out.println("Televizyon kapanıyor");
        System.exit(0);
    }
    public  void Mute()
    {
        volume=0;
        System.out.println("Ses seviyesi "+volume);
    }
    public void VolumeFull()
    {
        volume=10;
        System.out.println("Ses seviyesi " + volume);
    }
    public int Menu()
    {
        System.out.println("1.Kanal değiş");
        System.out.println("2.Ses aç");
        System.out.println("3.Ses kıs");
        System.out.println("4.Sesi tamamen kapat ");
        System.out.println("5.Sesi tamamen  aç ");
        System.out.println("6.Televizyonu kapat ");
        Scanner scanner=new Scanner(System.in);
        int c=scanner.nextInt();
        if (c==1)
        {
            KanalSec();
        }
        else if (c==2)
        {
            SesAc();
            return Menu();
        }
        else if (c==3)
        {
            SesKis();
            return Menu();
        }
        else if(c==4)
        {
           Mute();
           return Menu();
        }
        else if(c==5)
        {
            VolumeFull();
            return Menu();
        }
        else if (c==6)
        {
            Kapa();
        }

        return c;
    }


    public int getVolume()
    {
        return volume;
    }

    public void setVolume(int volume)
    {

        this.volume = volume;
    }
}
