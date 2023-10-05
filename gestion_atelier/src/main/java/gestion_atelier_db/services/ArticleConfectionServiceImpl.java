package gestion_atelier_db.services;

import java.util.ArrayList;

import gestion_atelier_db.entities.ArticleConfection;
import gestion_atelier_db.repositories.ITables;

public class ArticleConfectionServiceImpl implements ArticleConfectionService {


    //couplage faible
    private ITables<ArticleConfection> articleRepository;

    @Override
    public int add(ArticleConfection data) {
        return articleRepository.insert(data);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public int update(ArticleConfection data) {
        return articleRepository.update(data);
    }

    @Override
    public ArticleConfection show(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return articleRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (articleRepository.delete(ids[id])==0) {
                idsNotDelete[nbre++]=ids[id];

              }
          }
          return idsNotDelete;
    }
    
}
