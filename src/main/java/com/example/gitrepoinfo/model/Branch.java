package com.example.gitrepoinfo.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Branch {
    private String name;
    private Commit commit;
}
