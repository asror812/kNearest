package entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VolkiISobaki {
    public int k;
    public int x1;
    public int x2;
    public int x3;
    public int x4;
    public int x5;
    public int x6;


    @Override
    public String toString(){
        return "VolkiISobaki [k=" + k + ", x1=" + x1 + ", x2=" + x2 + ", x3=" + x3 + ", x4=" + x4 + ", x5=" + x5 + ", x6=" + x6 + "]";
    }
}
