package ru.psyfabriq.enterprise.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "FILE")
public class FileMO implements Serializable, Cloneable,Comparable<FileMO> {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String   id;
    @JsonIgnore
    private String   userId;
    private String   name;
    private String   rights;
    private String   mimeType;
    private double     size;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;
    private String   path;
    private boolean  isImage;
    private String   type;

   // @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    //@JoinColumn(name = "parent_id", nullable = false)
    private String parent;

    @Override
    public int compareTo(FileMO o) {
        return 0;
    }
}
