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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FOLDER")
public class FolderMO implements Serializable, Cloneable, Comparable<FolderMO>{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String   id;
    @JsonIgnore
    private String   userId;
    private String   name;
    private String   path;
    private String   type;
    private int      size;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date time;

    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE })
    @JoinColumn(name="parent_id")
    private FolderMO parent;

   // @OneToMany(mappedBy = "folder")
 //   private List<FileMO> files = new ArrayList<>();

    @Override
    public int compareTo(FolderMO o) {
        return id.compareTo(o.getId());
    }
}
