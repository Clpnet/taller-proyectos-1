package upc.ms.fast.beat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parametros {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public  int id;
    public String kmForNotification;
    public String emailsForKmNoti;

}
