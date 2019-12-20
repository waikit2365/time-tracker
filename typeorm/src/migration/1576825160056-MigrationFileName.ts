import {MigrationInterface, QueryRunner} from "typeorm";

export class MigrationFileName1576825160056 implements MigrationInterface {
    name = 'MigrationFileName1576825160056'

    public async up(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`CREATE TABLE "category" ("id" int NOT NULL IDENTITY(1,1), "title" nvarchar(255) NOT NULL, CONSTRAINT "PK_9c4e4a89e3674fc9f382d733f03" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`CREATE TABLE "schedule" ("id" int NOT NULL IDENTITY(1,1), "description" nvarchar(255) NOT NULL, "start_at" datetime NOT NULL, "end_at" datetime NOT NULL, "created_at" datetime NOT NULL, "modify_at" datetime NOT NULL, "plan_actual" nvarchar(255) NOT NULL, "category_id" int, CONSTRAINT "PK_1c05e42aec7371641193e180046" PRIMARY KEY ("id"))`, undefined);
        await queryRunner.query(`ALTER TABLE "schedule" ADD CONSTRAINT "FK_f6cb33f765a88ac60cff6315323" FOREIGN KEY ("category_id") REFERENCES "schedule"("id") ON DELETE NO ACTION ON UPDATE NO ACTION`, undefined);
    }

    public async down(queryRunner: QueryRunner): Promise<any> {
        await queryRunner.query(`ALTER TABLE "schedule" DROP CONSTRAINT "FK_f6cb33f765a88ac60cff6315323"`, undefined);
        await queryRunner.query(`DROP TABLE "schedule"`, undefined);
        await queryRunner.query(`DROP TABLE "category"`, undefined);
    }

}
